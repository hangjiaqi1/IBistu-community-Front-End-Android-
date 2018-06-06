package com.example.yrw.myapplication3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YRW on 2017/11/1.
 */

public class Viewpageradapter extends FragmentPagerAdapter {
    private List<Fragment> mFragmentList= new ArrayList<>();

    public Viewpageradapter(FragmentManager manager,List<Fragment> mFragmentList) {
        super(manager);
        this.mFragmentList=mFragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment) {
        mFragmentList.add(fragment);
    }
}
