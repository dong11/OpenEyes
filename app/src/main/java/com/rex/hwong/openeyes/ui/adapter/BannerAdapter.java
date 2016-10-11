package com.rex.hwong.openeyes.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 16/10/10
 * @time 下午10:57
 */

/**
 * 轮播图适配器
 */
public class BannerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragments;

    public BannerAdapter(FragmentManager fm, List<Fragment> fragments) {
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
}
