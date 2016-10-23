package com.rex.hwong.openeyes.ui.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.rex.hwong.openeyes.R;
import com.rex.hwong.openeyes.bean.discovery.detail.DetailData;
import com.rex.hwong.openeyes.presenter.IFindDetailPresenter;
import com.rex.hwong.openeyes.presenter.Impl.FindDetailPresenterImpl;
import com.rex.hwong.openeyes.ui.adapter.FindDetailAdapter;
import com.rex.hwong.openeyes.ui.fragment.FindDetailFragment;
import com.rex.hwong.openeyes.ui.iView.IFindDetailActivity;

import java.util.ArrayList;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FindDetailActivity extends BaseActivity implements IFindDetailActivity{

    @BindView(R.id.iv_title_back)
    ImageView ivTitleBack;
    @BindView(R.id.iv_title_search)
    ImageView ivTitleSearch;
    @BindView(R.id.vp_activity_find_detail)
    ViewPager mViewPager;

    private List<Fragment> mFragments;

    private FindDetailAdapter mAdapter;

    private IFindDetailPresenter mPresenter;

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

        mViewPager = (ViewPager) findViewById(R.id.vp_activity_find_detail);
        mFragments = new ArrayList<>();
        mAdapter = new FindDetailAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mAdapter);
    }

    private void initData() {
        mPresenter = new FindDetailPresenterImpl(this);
        mPresenter.getFindDetailData();
    }

    @Override
    public void getFindDetailData(ArrayList<DetailData> detailDatas) {
        mFragments.add(FindDetailFragment.newInstance(detailDatas));
        mFragments.add(FindDetailFragment.newInstance(detailDatas));
        mFragments.add(FindDetailFragment.newInstance(detailDatas));
        mAdapter.notifyDataSetChanged();
    }
}
