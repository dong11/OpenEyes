package com.rex.hwong.openeyes.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.rex.hwong.openeyes.R;
import com.rex.hwong.openeyes.utils.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 16/10/10
 * @time 下午11:32
 */

public class BannerItemFragment extends Fragment {

    private String mImageUrl;
    @BindView(R.id.img_banner)
    ImageView mImageBanner;
    private Unbinder mUnbinder;

    public BannerItemFragment() {

    }

    public static BannerItemFragment newInstance(String imageUrl) {
        BannerItemFragment bannerFragment = new BannerItemFragment();
        Bundle bundle = new Bundle();
        bundle.putString("imageUrl", imageUrl);
        bannerFragment.setArguments(bundle);
        return bannerFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImageUrl = getArguments().getString("imageUrl");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragemnt_find_banner_item, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initData();
    }

    private void initData(){
        ImageLoader.loadImage(getContext(), mImageUrl, mImageBanner);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
