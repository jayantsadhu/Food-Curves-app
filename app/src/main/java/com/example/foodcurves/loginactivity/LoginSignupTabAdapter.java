package com.example.foodcurves.loginactivity;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class LoginSignupTabAdapter extends FragmentPagerAdapter {

    Context context;
    int NUM_TABS;
    public LoginSignupTabAdapter(FragmentManager fm, Context context, int tabs) {
        super(fm);
        this.context = context;
        this.NUM_TABS = tabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return  new LogInTabFragment();
            case 1:
                return  new SignupTabFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return NUM_TABS;
    }
}
