package com.comtimes.android.comtimes.src.news_list;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.comtimes.android.comtimes.R;
import com.comtimes.android.comtimes.src.BaseActivity;
import com.comtimes.android.comtimes.src.news_list.models.NewsData;

import java.util.ArrayList;

public class NewsListActivity extends BaseActivity {
    private static final int NEWS = 0;
    private static final int EVENT = 1;
    private static final int INTERVIEW  = 2;
    private static final int ACTIVITY = 3;
    private static final int LECTURE = 4;
    private static final int INFO = 5;

    private RecyclerView mNewsListRv;
    private LinearLayoutManager mLayoutManager;
    private NewsListAdapter mNewsListAdapter;
    private ArrayList<NewsData> mDataList;

    private TextView mTitleTv;
    private ImageView mBackIv, msearchIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        mDataList = new ArrayList<>();

        mDataList.add(new NewsData(R.drawable.test, "그대의 쉼표, 제 23대 학생회 ‘Comma’의 회장단을 만나다.", "재학생 인터뷰 · 오현지 기자 · 2019.06.10"));
        mDataList.add(new NewsData(R.drawable.test2,"월드프렌즈 ICT 봉사단 인터뷰 우즈베키스탄&가나편","재학생 인터뷰 · 윤정민 기자 · 2018.12.24"));
        mDataList.add(new NewsData(R.drawable.test3, "한국투자증권 12학번 오민우 동문 인터뷰", "동문 인터뷰 · 박지영 기자 · 2018.12.10"));
        mDataList.add(new NewsData(R.drawable.test4, "ROTC 출신 11학번 서민우 동문인터뷰", "동문 인터뷰 · 김용현 기자 · 2018.10.29"));
        mDataList.add(new NewsData(R.drawable.test5, "Wong Kok Seng 교수님 인터뷰", "교수님 인터뷰 · 송지원 국장 · 2018.09.10"));
        mDataList.add(new NewsData(R.drawable.test6, "한국투자증권 12학번 오민우 동문 인터뷰", "동문 인터뷰 · 박지영 기자 · 2018.12.10"));


        mNewsListRv = findViewById(R.id.news_list_rv);
        mLayoutManager  = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mNewsListRv.setLayoutManager(mLayoutManager);
        mNewsListAdapter = new NewsListAdapter(mDataList, NewsListActivity.this);

        mNewsListRv.setAdapter(mNewsListAdapter);
        initViews();
    }

    @Override
    public void initViews() {
        super.initViews();
        mTitleTv = findViewById(R.id.news_list_title_tv);
        int type = getIntent().getIntExtra("type", -1);
        if(type < 0 )
            finish();

        setNewsTitle(type);

        mBackIv = findViewById(R.id.news_list_back_btn);
        msearchIv = findViewById(R.id.news_list_search_iv);

        mBackIv.setOnClickListener(this);
        msearchIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.news_list_back_btn:
                finish();
                break;
        }
    }

    private void setNewsTitle(int type){
        switch (type){
            case NEWS:
                mTitleTv.setText(getString(R.string.category_news));
                break;
            case EVENT:
                mTitleTv.setText(getString(R.string.category_event));
                break;
            case INTERVIEW:
                mTitleTv.setText(getString(R.string.category_interview));
                break;
            case ACTIVITY:
                mTitleTv.setText(getString(R.string.category_activity));
                break;
            case LECTURE:
                mTitleTv.setText(getString(R.string.category_lecture));
                break;
            case INFO:
                mTitleTv.setText(getString(R.string.category_info));
                break;
        }
    }
}
