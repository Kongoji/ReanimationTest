package com.example.kongoji.reanimationtest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.viewpagerindicator.IconPagerAdapter;

public class TestFragmentAdapter extends FragmentPagerAdapter implements IconPagerAdapter {

    private int mCount = 5;

    public TestFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getIconResId(int index) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = new Fragment1();
        switch (position) {
            case 0:
                fragment = new Fragment1();
                break;
            case 1:
                fragment = new Fragment2();
                break;
            case 2:
                fragment = new Fragment3();
                break;
            case 3:
                fragment = new Fragment4();
                break;
            case 4:
                fragment = new Fragment5();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "Erstbefund";
                break;
            case 1:
                title = "Maßnahmen";
                break;
            case 2:
                title = "Verlauf";
                break;
            case 3:
                title = "Übergabe";
                break;
            case 4:
                title = "Einsatzdaten";
                break;
        }
        return title;
    }

    public void setCount(int count) {
        if (count > 0 && count < 10) {
            mCount = count;
            notifyDataSetChanged();
        }
    }
}
