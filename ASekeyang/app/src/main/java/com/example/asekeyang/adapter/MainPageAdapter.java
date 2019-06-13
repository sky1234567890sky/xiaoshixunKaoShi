package com.example.asekeyang.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by 华为 on 2019/6/13.
 */

public class MainPageAdapter extends FragmentStatePagerAdapter{
    private final ArrayList<Fragment> fragments;

    public MainPageAdapter(FragmentManager supportFragmentManager, ArrayList<Fragment> fragments) {
        super(supportFragmentManager);


        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
