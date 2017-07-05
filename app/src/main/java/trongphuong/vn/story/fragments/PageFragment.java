package trongphuong.vn.story.fragments;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.StaticLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import trongphuong.vn.story.R;
import trongphuong.vn.story.adapters.ViewPagerAdapter;
import trongphuong.vn.story.utils.PageSplitter;
import trongphuong.vn.story.utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {
    private String contentInPage;
    private int width;
    private int height;

    public PageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_page, container, false);

        contentInPage = getArguments().getString(ViewPagerAdapter.STORY_KEY);
        width = Utils.getWidth(getActivity());
        height = Utils.getHeight(getActivity());

        ImageView imageView = (ImageView) view.findViewById(R.id.iv_content);
        imageView.setImageBitmap(getBitmap());

        return view;
    }

    public Bitmap getBitmap(){
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        StaticLayout staticLayout = PageSplitter.createStaticLayout(contentInPage);
        staticLayout.draw(canvas);

        return bitmap;
    }
}
