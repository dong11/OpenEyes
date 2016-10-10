package com.rex.hwong.openeyes.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rex.hwong.openeyes.R;
import com.rex.hwong.openeyes.bean.discovery.DiscoveryData;
import com.rex.hwong.openeyes.bean.discovery.DiscoveryItem;
import com.rex.hwong.openeyes.presenter.IFindPresenter;
import com.rex.hwong.openeyes.presenter.Impl.FindPresenterImpl;
import com.rex.hwong.openeyes.ui.iView.IFindFragment;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends Fragment implements IFindFragment {

    private IFindPresenter mPresenter;

    public FindFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_find, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initData();
    }

    private void initData() {
        mPresenter = new FindPresenterImpl(this);
        mPresenter.getDiscoveryInfo();
    }

    @Override
    public void getDiscoveryInfo(List<DiscoveryData> discoveryDatas) {
        Log.i("123", ":::" + discoveryDatas);
    }
}
