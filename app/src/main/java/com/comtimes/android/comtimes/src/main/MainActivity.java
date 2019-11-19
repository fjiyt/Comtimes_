package com.comtimes.android.comtimes.src.main;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.comtimes.android.comtimes.R;
import com.comtimes.android.comtimes.src.BaseActivity;
import com.comtimes.android.comtimes.src.main.models.RecentNewsData;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    //Drawer관련 멤버 변수 선언
    ImageView btnOpenDrawer;
    DrawerLayout drawerLayout;
    View drawerView;

    //Recylcerview 관련 멤버 변수 선언
    RecyclerView recentNewsRv;
    Context context;                                //Activity 관련 정보 담고 있음.
    LinearLayoutManager layoutManager;              //RecyclerView Item이 수직인지 수평인지 배치해주는 놈
    RecentNewsRvAdapter recentNewsRvAdapter;        //RecyclerView에 아이템 뿌려주고 관리하는 놈
    ArrayList<RecentNewsData> recentNewsDataList;   //RecyclerView Item에 들어가야될 DataList
    RequestManager mGlideRequestManager;            // 이미지 관련 라이브러리 이해안될테니 그냥 복붙해주세요.

    //최근뉴스데이터리스트에 넣어줄 더미데이터 5개
    String[] titles = {"LIG 넥스원 인턴 배형진, 황인건 학우 인터뷰","자취생을 지켜줘! 홍대영학우 인터뷰", "2019 숭실대학교 봄축제 ‘SSU:PECTRUM’",
    "2019 SCCC SCON Programming Contest", "2019 숭실대학교 IT 대학 봄축제"};
    int[] images = {R.drawable.dumy_img_1, R.drawable.dumy_img_2, R.drawable.dumy_img_3,
            R.drawable.dumy_img_4, R.drawable.dumy_img_5};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        btnOpenDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(drawerView);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_ham_btn :
                drawerLayout.openDrawer(drawerView);
                break;
        }
    }

    @Override
    public void initViews() {
        //Drawer
        drawerLayout = findViewById(R.id.main_drawer_layout);
        drawerView = findViewById(R.id.drawer);
        btnOpenDrawer = findViewById(R.id.main_ham_btn);


        //RecylcerView
        //RecyclerView ID 등록 및 DataList 객체 생성
        recentNewsRv = findViewById(R.id.main_recent_news_rv);
        recentNewsDataList = new ArrayList<>();
        //Glide RequestManager라는 걸 만들어서 MainActivity의 정보를 담아 Adapter에 보냅니다.
        mGlideRequestManager = Glide.with(this);

        //데이터리스트에 더미데이터들 삽입
        recentNewsDataList.add(new RecentNewsData(titles[0], images[0]));
        recentNewsDataList.add(new RecentNewsData(titles[1], images[1]));
        recentNewsDataList.add(new RecentNewsData(titles[2], images[2]));
        recentNewsDataList.add(new RecentNewsData(titles[3], images[3]));
        recentNewsDataList.add(new RecentNewsData(titles[4], images[4]));

        //Apater 등록과정
        layoutManager  = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        recentNewsRvAdapter = new RecentNewsRvAdapter(recentNewsDataList , context , mGlideRequestManager); // Adapter생성 - datalist와 MainActivity정보랑 같이
        //recyclerview에 layoutmanager와 adapter를 등록 - 마지막에!
        recentNewsRv.setLayoutManager(layoutManager);
        recentNewsRv.setAdapter(recentNewsRvAdapter);
    }

}
