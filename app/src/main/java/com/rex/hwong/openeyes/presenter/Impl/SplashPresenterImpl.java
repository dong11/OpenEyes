package com.rex.hwong.openeyes.presenter.Impl;

import com.rex.hwong.openeyes.presenter.ISplashPresenter;
import com.rex.hwong.openeyes.ui.iView.ISplashActivity;

import rx.Subscription;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 16/10/9
 * @time 下午2:33
 */

public class SplashPresenterImpl extends BasePresenterImpl implements ISplashPresenter {

    private ISplashActivity mISplashActivity;

    public SplashPresenterImpl(ISplashActivity activity){
        if(activity == null)
            throw new IllegalArgumentException("activity must not be null");
        mISplashActivity = activity;
    }

    @Override
    public void getStartInfo() {
        Subscription subscription = null;

        addSubscription(subscription);


        mISplashActivity.getStartInfo();
    }
}
