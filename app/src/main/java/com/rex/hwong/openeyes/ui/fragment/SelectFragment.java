package com.rex.hwong.openeyes.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.rex.hwong.openeyes.R;
import com.rex.hwong.openeyes.ui.widget.ObservableScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectFragment extends Fragment {

    @BindView(R.id.sv_fragment_select)
    ObservableScrollView mScrollView;
    @BindView(R.id.rl_fragment_select_header)
    RelativeLayout mHeaderView;
    @BindView(R.id.listview)
    ListView mListView;

    int mY;

    private Unbinder mUnbinder;

    public SelectFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mScrollView.setScrollViewListener(new ObservableScrollView.ScrollViewListener() {
            @Override
            public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
                Log.i("123", ":y:" + y);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                Log.i("123", "::" + (mListView.getHeight() - (y - oldy)));

                if(mY - (y - oldy) < 0){
                    params.setMargins(0, mY - (y - oldy), 0, 0);
                    mListView.setLayoutParams(params);
                    getListViewHeight(mListView);
                    mY = mY - (y - oldy);
                } else {
                    params.setMargins(0, 0, 0, 0);
                    mListView.setLayoutParams(params);
                    getListViewHeight(mListView);
                    mY = 0;
                }
            }
        });

        List<String> data = new ArrayList<>();

        for(int i = 0; i < 50; i++){
            data.add("item" + i);
        }

        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, data);
        mListView.setAdapter(adapter);
        getListViewHeight(mListView);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    /**
     * 重新计算ListView的高度
     * @param listView
     */
    private void getListViewHeight(ListView listView){
        ListAdapter listAdapter = listView.getAdapter();
        if(listAdapter == null){
            return;
        }
        int totalHeight = 0;
        for(int i = 0;i < listAdapter.getCount();i++){
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    /**
     * 获取当前屏幕高度
     * @param context
     * @return
     */
    private int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }
}
