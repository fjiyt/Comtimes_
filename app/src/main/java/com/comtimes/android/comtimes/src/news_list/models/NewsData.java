package com.comtimes.android.comtimes.src.news_list.models;

import android.graphics.drawable.Drawable;

public class NewsData {
    private int Thumbnail;
    private String title;
    private String subTitle;

    public NewsData(int Thumbnail, String title, String subTitle) {
        this.Thumbnail = Thumbnail;
        this.title = title;
        this.subTitle = subTitle;
    }
    public int getThumbnail() { return Thumbnail; }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }
}
