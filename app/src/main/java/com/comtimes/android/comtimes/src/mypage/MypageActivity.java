package com.comtimes.android.comtimes.src.mypage;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.comtimes.android.comtimes.R;
import com.comtimes.android.comtimes.src.BaseActivity;
import com.comtimes.android.comtimes.src.mypage.clip.ClipFragment;
import com.comtimes.android.comtimes.src.mypage.comment.CommentFragment;
import com.comtimes.android.comtimes.src.mypage.view.ViewFragment;
import com.google.android.material.tabs.TabLayout;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class MypageActivity extends BaseActivity {
    private Context mContext;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private ImageView mBackIv, mProfileIv;
    private TextView mModifyUserInfoTv, mNameTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);
        mContext = MypageActivity.this;
        mTabLayout = findViewById(R.id.mypage_tab);
        mViewPager = findViewById(R.id.mypage_viewpager);
        mBackIv = findViewById(R.id.mypage_back_iv);
        mProfileIv = findViewById(R.id.mypage_profile_iv);
        mModifyUserInfoTv = findViewById(R.id.mypage_modify_user_info_tv);
        mNameTv = findViewById(R.id.mypage_name_tv);

        mBackIv.setOnClickListener(this);
        mModifyUserInfoTv.setOnClickListener(this);
        initTab();
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()){
            case R.id.mypage_back_iv:
                finish();
                break;
            case R.id.mypage_modify_user_info_tv:
                break;
        }
    }

    private void initTab(){
        mTabLayout.setTabTextColors(getResources().getColor(R.color.textWhite),getResources().getColor(R.color.textWhite));
        mTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.mypageIndicator));
        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.my_page_clip)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.my_page_comment)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.my_page_view)));

        ClipFragment clipFragment = new ClipFragment(mContext);
        CommentFragment commentFragment = new CommentFragment(mContext);
        ViewFragment viewFragment = new ViewFragment(mContext);

        MyPageFragmentPagerAdapter myPageFragmentPagerAdapter = new MyPageFragmentPagerAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        myPageFragmentPagerAdapter.addFragment(clipFragment);
        myPageFragmentPagerAdapter.addFragment(commentFragment);
        myPageFragmentPagerAdapter.addFragment(viewFragment);


        mViewPager.setAdapter(myPageFragmentPagerAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}