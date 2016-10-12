package com.rex.hwong.openeyes.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.jude.rollviewpager.RollPagerView;
import com.rex.hwong.openeyes.R;
import com.rex.hwong.openeyes.bean.discovery.DiscoveryItem;
import com.rex.hwong.openeyes.presenter.IFindPresenter;
import com.rex.hwong.openeyes.presenter.Impl.FindPresenterImpl;
import com.rex.hwong.openeyes.ui.adapter.BannerAdapter;
import com.rex.hwong.openeyes.ui.adapter.FindRVAdapter;
import com.rex.hwong.openeyes.ui.iView.IFindFragment;
import com.rex.hwong.openeyes.ui.widget.DividerGridItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends Fragment implements IFindFragment {

    private IFindPresenter mPresenter;
    private List<Fragment> mFragments;
    private RollPagerView mPagerView;
    @BindView(R.id.rv_fragment_find)
    RecyclerView mRecyclerView;
    private Unbinder mUnbinder;

    private BannerAdapter mBannerAdapter;
    private FindRVAdapter mFindRVAdapter;

    private List<DiscoveryItem> mContentDatas;

    public FindFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
        initData();
    }

    private void initView() {
        mContentDatas = new ArrayList<>();
        mFindRVAdapter = new FindRVAdapter(getContext(), mContentDatas);
        mRecyclerView.setAdapter(mFindRVAdapter);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);

        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if(position == 0 || position == 3) {
                    return 2;
                }
                return 1;
            }
        });

        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(getContext()));
        mFindRVAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "点击了item!", Toast.LENGTH_SHORT).show();
            }
        });

        View bannerView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_find_banner, mRecyclerView, false);
        mPagerView = (RollPagerView) bannerView.findViewById(R.id.rpv_banner);
        mFindRVAdapter.setHeaderView(bannerView);
    }

    private void initData() {
        mFragments = new ArrayList<>();
        mBannerAdapter = new BannerAdapter(getChildFragmentManager(), mFragments);
        mPagerView.setAdapter(mBannerAdapter);

        mPresenter = new FindPresenterImpl(this);
        mPresenter.getDiscoveryInfo();
    }

    @Override
    public void getDiscoveryInfo(List<DiscoveryItem> bannerDatas, List<DiscoveryItem> contentDatas) {
        if (bannerDatas == null || contentDatas == null) return;
        mContentDatas.addAll(contentDatas);
        for(int i = 0; i < bannerDatas.size(); i++) {
            mFragments.add(BannerItemFragment.newInstance(bannerDatas.get(i).getImage()));
        }
        mBannerAdapter.notifyDataSetChanged();
        mFindRVAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
        mPresenter.unsubcrible();
    }
}
