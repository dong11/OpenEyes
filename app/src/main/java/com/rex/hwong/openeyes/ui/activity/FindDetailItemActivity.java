package com.rex.hwong.openeyes.ui.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.rex.hwong.openeyes.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FindDetailItemActivity extends AppCompatActivity {

    @BindView(R.id.imageView)
    ImageView imageView;

    private Bundle mEndValues;
    private Bundle mStartValues;
    private String mImageUrl;
    private float mDeltaY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_detail_item);
        ButterKnife.bind(this);

        extractViewInfoFromBundle(getIntent());

        Glide.with(this).load("http://img.kaiyanapp.com/85d8f9741d093d40451ccfde16229698.jpeg?imageMogr2/quality/60").listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                Log.i("123", ":加载失败:");
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                Log.i("123", ":加载成功:");
                onUiReady();
                return false;
            }
        }).into(imageView);
    }

    private void onUiReady() {
        imageView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                // remove previous listener
                imageView.getViewTreeObserver().removeOnPreDrawListener(this);
                // prep the scene
                prepareScene();
                // run the animation
                runEnterAnimation();
                return true;
            }
        });
    }

    private void runEnterAnimation() {
        // We can now make it visible
        imageView.setVisibility(View.VISIBLE);
        // finally, run the animation

        imageView.animate()
                .setDuration(500)
                .setInterpolator(new DecelerateInterpolator())
                .scaleX(1f)
                .scaleY(1f)
                .translationX(0)
                .translationY(0)
                .start();
    }
    private void prepareScene() {
        // capture the end values in the destionation view
        mEndValues = captureValues(imageView);

        // calculate the scale and positoin deltas
//        float scaleX = scaleDelta(mStartValues, mEndValues);
        float scaleY = scaleDelta(mStartValues, mEndValues);
//        int deltaX = translationDelta(mStartValues, mEndValues);
//        int deltaY = translationDelta(mStartValues, mEndValues);
        translationDelta(mStartValues, mEndValues);

        // scale and reposition the image
        imageView.setScaleX(1.2f);
        imageView.setScaleY(1.2f);
        imageView.setTranslationX(0);
        imageView.setTranslationY(mDeltaY);
    }

    private void translationDelta(Bundle values, Bundle values1) {
        mDeltaY = values.getInt("top") -  values1.getInt("top");
    }

    private float scaleDelta(Bundle values, Bundle values1) {
        return values.getInt("height") /  values1.getInt("height");
    }

    private void extractViewInfoFromBundle(Intent intent) {
        mStartValues = intent.getBundleExtra("info");
        mImageUrl = intent.getStringExtra("imageUrl");
    }

    private Bundle captureValues(@NonNull View view) {
        Bundle b = new Bundle();
        int[] screenLocation = new int[2];
        view.getLocationOnScreen(screenLocation);
        b.putInt("left", screenLocation[0]);
        b.putInt("top", screenLocation[1]);
        b.putInt("width", view.getWidth());
        b.putInt("height", view.getHeight());
        return b;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void runExitAnimation() {
        imageView.animate()
                .setDuration(500)
                .setInterpolator(new DecelerateInterpolator())
                .scaleX(1)
                .scaleY(1)
                .translationX(0)
                .translationY(mDeltaY)
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                        overridePendingTransition(0, 0);
                    }
                }).start();
    }

    @Override
    public void onBackPressed() {
        runExitAnimation();
    }
}
