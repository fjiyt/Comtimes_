package com.comtimes.android.comtimes.src.mypage;

import android.os.Bundle;
import android.widget.TabHost;

import androidx.appcompat.app.AppCompatActivity;

import com.comtimes.android.comtimes.R;

public class MypageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);
        TabHost tabHost = findViewById(R.id.host);
        tabHost.setup();
        TabHost.TabSpec spec = tabHost.newTabSpec("tab1");
        spec.setIndicator("스크랩함");
        spec.setContent(R.id.tab_content1);
        tabHost.addTab(spec);
        spec = tabHost.newTabSpec("tab2");
        spec.setIndicator("댓글 단 기사");
        spec.setContent(R.id.tab_content2);
        tabHost.addTab(spec);
        spec = tabHost.newTabSpec("tab3");
        spec.setIndicator("본 기사");
        spec.setContent(R.id.tab_content3);
       tabHost.addTab(spec);
    }
}