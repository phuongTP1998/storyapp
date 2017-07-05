package trongphuong.vn.story.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.StaticLayout;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import trongphuong.vn.story.databases.StoryModel;
import trongphuong.vn.story.fragments.PageFragment;
import trongphuong.vn.story.utils.PageSplitter;

/**
 * Created by trongphuong1011 on 6/28/2017.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter{
    private static final String TAG = "ViewPagerAdapter";
    private List<String> listPage = new ArrayList<>();
    public static final String STORY_KEY = "story_key";

    public ViewPagerAdapter(FragmentManager fm, StoryModel storyModel, int width, int height) {
        super(fm);

        new PageSplitter(storyModel.getContent(), width, height);
        StaticLayout staticLayout = PageSplitter.createStaticLayout(storyModel.getContent());
        listPage = PageSplitter.splitPage(staticLayout);
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putString(STORY_KEY, listPage.get(position));
        PageFragment pageFragment = new PageFragment();
        pageFragment.setArguments(bundle);
        return pageFragment;
    }

    @Override
    public int getCount() {
        return listPage.size();
    }
}
