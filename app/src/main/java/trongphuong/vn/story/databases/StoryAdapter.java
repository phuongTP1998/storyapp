package trongphuong.vn.story.databases;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import trongphuong.vn.story.R;
import trongphuong.vn.story.activities.DescriptionActivity;

/**
 * Created by trongphuong1011 on 6/17/2017.
 */

public class StoryAdapter extends ArrayAdapter<StoryModel>{
    private Context context;
    private int resource;
    private List<StoryModel> storyModelList;
    public StoryAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<StoryModel> objects) {
        super(context, resource, objects);

        this.context= context;
        this.resource=resource;
        this.storyModelList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.item_list_story,null);
        final StoryModel storyModel = storyModelList.get(position);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
        TextView tvAuthor = (TextView) convertView.findViewById(R.id.tv_author);
        ImageView ivStory = (ImageView) convertView.findViewById(R.id.iv_story);

        tvTitle.setText(storyModel.getTitle());
        tvAuthor.setText(storyModel.getAuthor());

        String image[] = storyModel.getImage().split(",");
        byte[] decodeByte = Base64.decode(image[1], Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(decodeByte, 0, decodeByte.length);
        ivStory.setImageBitmap(bitmap);

        CardView cardView = (CardView) convertView.findViewById(R.id.cv_story);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DescriptionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(context.getString(R.string.story_model_name), storyModel);
                intent.putExtras(bundle);

                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
