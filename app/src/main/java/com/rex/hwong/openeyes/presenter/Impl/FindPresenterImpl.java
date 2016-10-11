package com.rex.hwong.openeyes.presenter.Impl;

import android.util.Log;

import com.rex.hwong.openeyes.api.discovery.DiscoveryRequest;
import com.rex.hwong.openeyes.bean.discovery.DiscoveryData;
import com.rex.hwong.openeyes.bean.discovery.DiscoveryItem;
import com.rex.hwong.openeyes.bean.discovery.DiscoveryResponse;
import com.rex.hwong.openeyes.presenter.IFindPresenter;
import com.rex.hwong.openeyes.ui.iView.IFindFragment;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 16/10/10
 * @time 下午5:46
 */

public class FindPresenterImpl extends BasePresenterImpl implements IFindPresenter {

    private IFindFragment mIFindFragment;

    public FindPresenterImpl(IFindFragment fragment) {
        if(fragment == null)
            throw new IllegalArgumentException("fragment must not be null");
        mIFindFragment = fragment;
    }

    @Override
    public void getDiscoveryInfo() {
        Subscription subscription = DiscoveryRequest.getDiscoveryApi().getDiscoveryInfo()
                .subscribeOn(Schedulers.io())
                .map(new Func1<DiscoveryResponse, List<DiscoveryData>>() {
                    @Override
                    public List<DiscoveryData> call(DiscoveryResponse response) {
                        return response.getItemList();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<DiscoveryData>>(){

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("123", ":获取数据失败: " + e);
                    }

                    @Override
                    public void onNext(List<DiscoveryData> discoveryDatas) {
                        List<DiscoveryItem> contentList = new ArrayList<DiscoveryItem>();
                        List<DiscoveryItem> bannerList = new ArrayList<DiscoveryItem>();
                        for(DiscoveryData data : discoveryDatas){
                            if(data.getData().getItemList() != null){
                                for(DiscoveryData bannerData : data.getData().getItemList()){
                                    bannerList.add(bannerData.getData());
                                }
                            } else {
                                contentList.add(data.getData());
                            }
                        }
                        mIFindFragment.getDiscoveryInfo(bannerList, contentList);
                    }
                });
        addSubscription(subscription);
    }
}
