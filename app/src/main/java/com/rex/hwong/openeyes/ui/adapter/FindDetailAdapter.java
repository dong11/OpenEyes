package com.rex.hwong.openeyes.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 2016/10/23
 * @time 下午4:17
 */

public class FindDetailAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;

    private static final String[] TITLES = {"周排行", "月排行", "总排行"};

    public FindDetailAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }
}
