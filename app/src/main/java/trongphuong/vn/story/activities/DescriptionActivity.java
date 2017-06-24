package trongphuong.vn.story.activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import trongphuong.vn.story.R;
import trongphuong.vn.story.databases.DatabaseHandle;
import trongphuong.vn.story.databases.StoryModel;

/**
 * Created by trongphuong1011 on 6/21/2017.
 */

public class DescriptionActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView ivBack;
    private ImageView ivBookmark;
    private ImageView ivStory;
    private TextView tvTitle;
    private TextView tvAuthor;
    private TextView tvDescription;
    private Button btStartReading;

    private StoryModel storyModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.descriptionactivity);

        setupUI();
        loadData();
    }

    private void loadData() {
        storyModel = (StoryModel) getIntent().getExtras().getSerializable(getString(R.string.story_model_name));

        String image[] = storyModel.getImage().split(",");
        byte[] decodeByte = Base64.decode(image[1], Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(decodeByte, 0, decodeByte.length);
        ivStory.setImageBitmap(bitmap);

        tvTitle.setText(storyModel.getTitle());
        tvAuthor.setText(storyModel.getAuthor());
        tvDescription.setText(storyModel.getDescription());

        if(storyModel.isBookmark()){
            ivBookmark.setImageResource(R.drawable.ic_bookmark_black_24dp);
        } else{
            ivBookmark.setImageResource(R.drawable.ic_bookmark_border_black_24dp);
        }
    }

    private void setupUI() {
        ivBack = (ImageView) findViewById(R.id.iv_back);
        ivBookmark = (ImageView) findViewById(R.id.iv_bookmark);
        ivStory = (ImageView) findViewById(R.id.iv_story);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvAuthor = (TextView) findViewById(R.id.tv_author);
        tvDescription = (TextView) findViewById(R.id.tv_description);
        btStartReading = (Button) findViewById(R.id.bt_start_reading);

        ivBack.setOnClickListener(this);
        ivBookmark.setOnClickListener(this);
        btStartReading.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_start_reading:
                startReading();
                break;
            case R.id.iv_back:
                super.onBackPressed();
                break;
            case R.id.iv_bookmark:
                setBookmark();
                break;
        }
    }

    private void setBookmark() {
        if(storyModel.isBookmark()){
            ivBookmark.setImageResource(R.drawable.ic_bookmark_border_black_24dp);
            DatabaseHandle.getInstance(this).setBookmark(false, storyModel);
            storyModel.setBookmark(false);
        } else {
            ivBookmark.setImageResource(R.drawable.ic_bookmark_black_24dp);
            DatabaseHandle.getInstance(this).setBookmark(true, storyModel);
            storyModel.setBookmark(true);
        }
    }

    private void startReading() {
    }
}
