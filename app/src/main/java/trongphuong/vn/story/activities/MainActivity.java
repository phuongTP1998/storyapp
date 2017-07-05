package trongphuong.vn.story.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import trongphuong.vn.story.R;
import trongphuong.vn.story.databases.DatabaseHandle;
import trongphuong.vn.story.adapters.StoryAdapter;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.toString();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lv_story);

    }

    @Override
    protected void onResume() {
        super.onResume();
        StoryAdapter storyAdapter = new StoryAdapter(this,R.layout.item_list_story,
                DatabaseHandle.getInstance(this).getListStory());
        listView.setAdapter(storyAdapter);
    }
}
