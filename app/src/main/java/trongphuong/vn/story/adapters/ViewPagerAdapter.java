package trongphuong.vn.story.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import trongphuong.vn.story.fragments.PageFragment;

/**
 * Created by trongphuong1011 on 6/28/2017.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter{
    private static final String TAG = "ViewPagerAdapter";

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Log.d(TAG, "getItem: " + position );
        return new PageFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }
}
