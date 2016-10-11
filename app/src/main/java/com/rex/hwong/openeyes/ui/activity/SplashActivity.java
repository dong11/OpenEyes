package com.rex.hwong.openeyes.ui.activity;

import android.os.Bundle;

import com.rex.hwong.openeyes.R;
import com.rex.hwong.openeyes.presenter.ISplashPresenter;
import com.rex.hwong.openeyes.presenter.Impl.SplashPresenterImpl;
import com.rex.hwong.openeyes.ui.iView.ISplashActivity;

public class SplashActivity extends BaseActivity implements ISplashActivity{

    private ISplashPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mPresenter = new SplashPresenterImpl(this);
        mPresenter.getStartInfo();
    }

    @Override
    public void getStartInfo() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unsubcrible();
    }
}
