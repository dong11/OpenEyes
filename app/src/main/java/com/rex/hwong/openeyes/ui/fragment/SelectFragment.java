package com.rex.hwong.openeyes.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rex.hwong.openeyes.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectFragment extends Fragment {


    public SelectFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_select, container, false);
    }

}
