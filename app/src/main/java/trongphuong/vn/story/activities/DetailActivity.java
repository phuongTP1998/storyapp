package trongphuong.vn.story.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import trongphuong.vn.story.R;
import trongphuong.vn.story.adapters.ViewPagerAdapter;
import trongphuong.vn.story.databases.StoryModel;
import trongphuong.vn.story.utils.Utils;

public class DetailActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        viewPager = (ViewPager) findViewById(R.id.vp_story);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),
                (StoryModel) getIntent().getExtras().getSerializable(ViewPagerAdapter.STORY_KEY),
                Utils.getWidth(this),Utils.getHeight(this));
        viewPager.setAdapter(viewPagerAdapter);
    }
}
