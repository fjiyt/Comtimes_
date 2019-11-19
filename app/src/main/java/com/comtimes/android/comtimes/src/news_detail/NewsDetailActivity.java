package com.comtimes.android.comtimes.src.news_detail;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.comtimes.android.comtimes.R;
import com.comtimes.android.comtimes.src.BaseActivity;

import java.util.ArrayList;

public class NewsDetailActivity extends BaseActivity {
    private TextView mCategoryTv, mTitleTv, mSubTitleTv, mReporterTv, mDateTv, mClipTv, mCommentTv;
    private ImageView mProfileIv, mBackIv, mShareIv , mImg1Iv, mImg2Iv, mImg3Iv, mImg4Iv;
    private NewsData mNewsData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        mImg1Iv = findViewById(R.id.news_detail_image1_iv);
        mImg2Iv = findViewById(R.id.news_detail_image2_iv);
        mImg3Iv = findViewById(R.id.news_detail_image3_iv);
        mImg4Iv = findViewById(R.id.news_detail_image4_iv);

        ArrayList<String> contents = new ArrayList<>();
        Glide.with(this).load(R.drawable.content_img1).into(mImg1Iv);
        Glide.with(this).load(R.drawable.content_img2).into(mImg2Iv);
        Glide.with(this).load(R.drawable.content_img3).into(mImg3Iv);
        Glide.with(this).load(R.drawable.content_img4).into(mImg4Iv);
    }

    private void setArticle(){
    }
}
