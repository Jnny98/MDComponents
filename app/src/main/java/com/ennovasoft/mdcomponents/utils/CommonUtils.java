package com.ennovasoft.mdcomponents.utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.ennovasoft.mdcomponents.fragments.BottomNavigationBarFragment;
import com.ennovasoft.mdcomponents.fragments.ButtonFragment;
import com.ennovasoft.mdcomponents.fragments.SnackBarFragment;

public class CommonUtils {

    public static void setFragment(AppCompatActivity activity, String nameFragment, int contentRes) {
        Fragment fragment = getFragmentById(nameFragment);
        activity.getSupportFragmentManager().beginTransaction()
                .add(contentRes, fragment)
                .commit();
    }

    private static Fragment getFragmentById(String nameFragment) {
        Fragment fragment = null;

        switch (nameFragment) {
            //SCROLL
            case ButtonFragment.TAG:
                fragment = new ButtonFragment();
                break;

            //STATIC
            case BottomNavigationBarFragment.TAG:
                fragment = new BottomNavigationBarFragment();
                break;

            case SnackBarFragment.TAG:
                fragment = new SnackBarFragment();
                break;
        }

        return fragment;
    }
}
