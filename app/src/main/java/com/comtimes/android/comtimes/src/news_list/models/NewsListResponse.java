package com.comtimes.android.comtimes.src.news_list.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NewsListResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private ArrayList<NewsListData> dataList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public ArrayList<NewsListData> getResult(){ return dataList; }
}