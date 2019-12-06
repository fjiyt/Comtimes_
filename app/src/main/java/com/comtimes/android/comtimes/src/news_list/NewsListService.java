package com.comtimes.android.comtimes.src.news_list;

import com.comtimes.android.comtimes.src.news_list.interfaces.NewsListActivityView;
import com.comtimes.android.comtimes.src.news_list.interfaces.NewsListRetrofitInterface;
import com.comtimes.android.comtimes.src.news_list.models.NewsListResponse;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.comtimes.android.comtimes.src.ApplicationClass.getRetrofit;

class NewsListService {
    private final NewsListActivityView mNewsListActivityView;

    NewsListService(final NewsListActivityView newsListActivityView) {
        this.mNewsListActivityView = newsListActivityView;
    }

    void getNewsList(String type, int page) {
        final NewsListRetrofitInterface newsListRetrofitInterface = getRetrofit().create(NewsListRetrofitInterface.class);
        newsListRetrofitInterface.getNewsList(type, page).enqueue(new Callback<NewsListResponse>() {
            @Override
            public void onResponse(@NotNull Call<NewsListResponse> call, @NotNull Response<NewsListResponse> response) {
                final NewsListResponse newsListResponse = response.body();
                if (newsListResponse == null) {
                    mNewsListActivityView.getNewsListFailure(null);
                }else if(newsListResponse.getCode() == 100){
                    mNewsListActivityView.getNewsListSuccess(newsListResponse.getResult());
                }else if(newsListResponse.getCode() == 401){
                    mNewsListActivityView.getNewsListFailure(newsListResponse.getMessage());
                }
            }

            @Override
            public void onFailure(@NotNull Call<NewsListResponse> call, @NotNull Throwable t) {
                mNewsListActivityView.getNewsListFailure(null);
            }
        });
    }
}
