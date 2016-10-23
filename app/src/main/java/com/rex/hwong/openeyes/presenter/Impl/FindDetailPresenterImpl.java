package com.rex.hwong.openeyes.presenter.Impl;

import android.util.Log;

import com.rex.hwong.openeyes.api.discovery.DiscoveryDetailRequest;
import com.rex.hwong.openeyes.bean.discovery.detail.DetailData;
import com.rex.hwong.openeyes.bean.discovery.detail.DetailItem;
import com.rex.hwong.openeyes.bean.discovery.detail.DetailResponse;
import com.rex.hwong.openeyes.presenter.IFindDetailPresenter;
import com.rex.hwong.openeyes.ui.iView.IFindDetailActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 2016/10/22
 * @time 下午10:16
 */

public class FindDetailPresenterImpl extends BasePresenterImpl implements IFindDetailPresenter {

    private IFindDetailActivity mIFindDetailActivity;

    public FindDetailPresenterImpl(IFindDetailActivity activity){
        if(activity == null)
            throw new IllegalArgumentException("activity must not be null");
        mIFindDetailActivity = activity;
    }


    @Override
    public void getFindDetailData() {
        Subscription subscription = DiscoveryDetailRequest.getDetailApi().getDetailInfo()
                .subscribeOn(Schedulers.io())
                .map(new Func1<DetailResponse, ArrayList<DetailData>>() {
                    @Override
                    public ArrayList<DetailData> call(DetailResponse response) {
                        return response.getItemList();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArrayList<DetailData>>(){

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("123", ":获取数据失败: " + e);
                    }

                    @Override
                    public void onNext(ArrayList<DetailData> detailDatas) {
                        mIFindDetailActivity.getFindDetailData(detailDatas);
                    }
                });
        addSubscription(subscription);
    }
}
