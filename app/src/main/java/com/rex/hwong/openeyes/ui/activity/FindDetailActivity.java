package com.rex.hwong.openeyes.ui.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.rex.hwong.openeyes.R;

import java.util.ArrayList;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FindDetailActivity extends BaseActivity {

    @BindView(R.id.iv_title_back)
    ImageView ivTitleBack;
    @BindView(R.id.iv_title_search)
    ImageView ivTitleSearch;
    @BindView(R.id.vp_activity_find_detail)
    ViewPager mViewPager;

    private List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_detail);
        ButterKnife.bind(this);

        initView();

        initData();
    }

    private void initView() {
        ivTitleBack.setVisibility(View.VISIBLE);
        ivTitleSearch.setVisibility(View.GONE);
        ivTitleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initData() {
        mFragments = new ArrayList<>();
    }

    private void initMagicIndicator(){

    }
}
