package com.rex.hwong.openeyes.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.rex.hwong.openeyes.R;
import com.rex.hwong.openeyes.bean.discovery.detail.DetailData;
import com.rex.hwong.openeyes.ui.activity.FindDetailItemActivity;
import com.rex.hwong.openeyes.ui.activity.PlayerActivity;
import com.rex.hwong.openeyes.ui.adapter.FindDetailAdapter;
import com.rex.hwong.openeyes.ui.adapter.FindDetailItemAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 16/10/13
 * @time 下午2:53
 */

public class FindDetailFragment extends Fragment {

    @BindView(R.id.rv_fragment_find_detail)
    RecyclerView mRecyclerView;

    private FindDetailItemAdapter mAdapter;

    private List<DetailData> mList;

    public FindDetailFragment() {
    }

    public static FindDetailFragment newInstance(ArrayList<DetailData> list) {
        FindDetailFragment findDetailFragment = new FindDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", list);
        findDetailFragment.setArguments(bundle);
        return findDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mList = (List<DetailData>) getArguments().getSerializable("data");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find_detail, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdapter = new FindDetailItemAdapter(getActivity(), mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                ImageView imageView = (ImageView) view.findViewById(R.id.iv_fragment_find_detail_item);
//                launch(imageView, "");
                Intent intent = new Intent(getActivity(), PlayerActivity.class);
                startActivity(intent);
            }
        });
    }

    private void launch(View view, String imageUrl){
        Intent intent = new Intent(getContext(), FindDetailItemActivity.class);
        intent.putExtra("imageUrl", imageUrl);
        intent.putExtra("info", /* start values */ captureValues(view));

        startActivity(intent);
        getActivity().overridePendingTransition(0, 0);
    }

    private Bundle captureValues(@NonNull View view) {
        Bundle b = new Bundle();
        int[] screenLocation = new int[2];
        view.getLocationOnScreen(screenLocation);
        Log.i("123", ":cy:" + screenLocation[1]);
        b.putInt("left", screenLocation[0]);
        b.putInt("top", screenLocation[1]);
        b.putInt("width", view.getWidth());
        b.putInt("height", view.getHeight());
        return b;
    }
}
