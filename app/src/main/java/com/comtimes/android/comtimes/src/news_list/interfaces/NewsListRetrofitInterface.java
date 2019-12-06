package com.comtimes.android.comtimes.src.news_list.interfaces;

import com.comtimes.android.comtimes.src.news_list.models.NewsListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NewsListRetrofitInterface {
    @GET("/articles/{type}/page/{page}")
    Call<NewsListResponse> getNewsList(
            @Path("type") String type,
            @Path("page") int page
    );
}
