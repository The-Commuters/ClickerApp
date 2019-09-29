package com.usn.clickergame;

import android.content.Context;

import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.usn.clickergame.ui.clicker.fragments.ClickerFragment;
import com.usn.clickergame.ui.clicker.fragments.UpgradesFragment;
import com.usn.clickergame.ui.options.OptionsFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.title_activity_clicker, R.string.title_activity_upgrades, R.string.title_activity_options};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // https://codinginflow.com/tutorials/android/tab-layout-with-fragments
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1: return UpgradesFragment.newInstance();
            case 2: return new OptionsFragment();
            default: return ClickerFragment.newInstance();
        }
    }





    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }




}