package com.comtimes.android.comtimes.src.main.models;

public class RecentNewsData {
    String title;
    int newsImg;

    public RecentNewsData(String title, int newsImg){
        this.title = title;
        this.newsImg = newsImg;
    }

    public String getTitle(){
        return title;
    }

    public int getNewsImg(){
        return newsImg;
    }
}
