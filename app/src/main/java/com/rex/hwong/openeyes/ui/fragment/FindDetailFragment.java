package com.rex.hwong.openeyes.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rex.hwong.openeyes.R;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 16/10/13
 * @time 下午2:53
 */

public class FindDetailFragment extends Fragment {

    public FindDetailFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_find_detail, container, false);
    }
}
