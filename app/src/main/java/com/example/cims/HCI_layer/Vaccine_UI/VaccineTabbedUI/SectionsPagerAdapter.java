package com.example.cims.HCI_layer.Vaccine_UI.VaccineTabbedUI;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.cims.HCI_layer.ConfirmedCase_UI.MapsActivity;
import com.example.cims.HCI_layer.ConfirmedCase_UI.TableActivity;
import com.example.cims.HCI_layer.Vaccine_UI.AstrazenecaActivity;
import com.example.cims.HCI_layer.Vaccine_UI.JanssenActivity;
import com.example.cims.HCI_layer.Vaccine_UI.ModernaActivity;
import com.example.cims.HCI_layer.Vaccine_UI.PfizerActivity;
import com.example.cims.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.vaccine_1, R.string.vaccine_2,R.string.vaccine_3,R.string.vaccine_4};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new PfizerActivity();
                break;
            case 1:
                fragment = new ModernaActivity();
                break;
            case 2:
                fragment = new JanssenActivity();
                break;
            case 3:
                fragment = new AstrazenecaActivity();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 4 total pages.
        return 4;
    }
}