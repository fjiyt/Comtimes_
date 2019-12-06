package com.comtimes.android.comtimes.src.news_list.models;

import android.graphics.drawable.Drawable;

import com.google.gson.annotations.SerializedName;

public class NewsListData {
    @SerializedName("articleNo")
    private int articleNo;
    @SerializedName("thumbnail")
    private String thumbnail;
    @SerializedName("type")
    private String type;
    @SerializedName("title")
    private String title;
    @SerializedName("reporter")
    private String reporter;
    @SerializedName("registered_timestamp")
    private String registered_timestamp;

    public int getArticleNo() {
        return articleNo;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getReporter() {
        return reporter;
    }

    public String getRegistered_timestamp() {
        return registered_timestamp;
    }
}
