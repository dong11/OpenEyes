package com.rex.hwong.openeyes.ui.widget;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.rex.hwong.openeyes.R;
import com.rex.hwong.openeyes.ui.widget.tagview.Tag;
import com.rex.hwong.openeyes.ui.widget.tagview.TagListView;
import com.rex.hwong.openeyes.ui.widget.tagview.TagView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 16/10/11
 * @time 下午5:08
 */

public class SearchPopWindow implements PopupWindow.OnDismissListener {
    private PopupWindow mPopupWindow;
    private Activity mContext;
    private View viewParent;
    private View contentView;
    private TextView mSearchCancel;
    private TagListView mTagListView;
    private List<Tag> mTags;

    public SearchPopWindow(Activity activity) {
        mContext = activity;

        initView();

        initData();
    }

    private void initView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.search_popwindow, null);
        mPopupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        contentView = view.findViewById(R.id.ll_search_content);
        mPopupWindow.setOnDismissListener(this);
        viewParent = mContext.findViewById(android.R.id.content);
        mSearchCancel = (TextView) view.findViewById(R.id.tv_search_cancel);
        mSearchCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dimiss();
            }
        });
        mTagListView = (TagListView) view.findViewById(R.id.search_tagview);

        mTagListView.setOnTagClickListener(new TagListView.OnTagClickListener() {
            @Override
            public void onTagClick(TagView tagView, Tag tag) {
                Toast.makeText(mContext, "search::" + tag.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        mTags = new ArrayList<>();
        for(int i = 1; i < 21; i++){
            mTags.add(new Tag(i, "search:" + i));
        }

        mTagListView.addTags(mTags);
    }

    public void show() {
        if(mPopupWindow != null && !mPopupWindow.isShowing()) {
            View view = viewParent.findViewById(R.id.title_bar);
            startAnimation();
            mPopupWindow.showAsDropDown(view, 0, -view.getHeight());
        }
    }

    public void dimiss() {
        if(mPopupWindow != null)
            mPopupWindow.dismiss();
    }

    private void startAnimation(){
        Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.popwindow_enter);
        contentView.setAnimation(animation);
    }

    private void endAnimation(){
        Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.popwindow_exit);
        contentView.setAnimation(animation);
    }

    @Override
    public void onDismiss() {
        endAnimation();
    }
}
