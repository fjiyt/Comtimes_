package com.comtimes.android.comtimes.src.news_list.interfaces;

import com.comtimes.android.comtimes.src.news_list.models.NewsListData;

import java.util.ArrayList;

public interface NewsListActivityView {
    void getNewsListSuccess(ArrayList<NewsListData> dataList);

    void getNewsListFailure(String message);
}
