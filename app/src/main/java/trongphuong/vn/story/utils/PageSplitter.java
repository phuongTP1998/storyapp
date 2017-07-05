package trongphuong.vn.story.utils;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by trongphuong1011 on 7/5/2017.
 */

public class PageSplitter {
    private static String content;
    private static int width;
    private static int height;
    private static List<String> listPage = new ArrayList<>();

    public PageSplitter(String content, int width, int height) {
        PageSplitter.content = content;
        PageSplitter.width = width;
        PageSplitter.height = height;
    }

    public static StaticLayout createStaticLayout(String content){
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(32);
        // paint more beautiful
        textPaint.setAntiAlias(true);

        return new StaticLayout(content, textPaint, width, Layout.Alignment.ALIGN_NORMAL, 0.5f , 10f, false);
    }

    public static List<String> splitPage(StaticLayout staticLayout){
        int startLine = 0;
        while(startLine < staticLayout.getLineCount()){
            //return position first of page
            int startLineTop = staticLayout.getLineTop(startLine);
            //return position last of page
            int endLine = staticLayout.getLineForVertical(startLineTop + height);
            //return toa do dong cuoi trong trang
            int endLineBottom = staticLayout.getLineBottom(endLine);

            int visibleLine;
            if(endLineBottom > startLineTop + height){
                visibleLine = endLine - 1 ;
            } else {
                visibleLine = endLine;
            }

            int start = staticLayout.getLineStart(startLine);
            int end = staticLayout.getLineEnd(visibleLine);

            listPage.add(content.substring(start, end));
            startLine = visibleLine + 1;
        }
        return listPage;
    }
}
