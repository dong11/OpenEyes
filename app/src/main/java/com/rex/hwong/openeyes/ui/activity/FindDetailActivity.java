package com.rex.hwong.openeyes.ui.activity;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.rex.hwong.openeyes.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FindDetailActivity extends FragmentActivity {

    @BindView(R.id.iv_title_back)
    ImageView ivTitleBack;
    @BindView(R.id.iv_title_search)
    ImageView ivTitleSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_detail);
        ButterKnife.bind(this);

        initView();
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
}
