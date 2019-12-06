package com.comtimes.android.comtimes.src.mypage.clip;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.comtimes.android.comtimes.R;
import com.comtimes.android.comtimes.src.BaseFragment;

import java.util.ArrayList;

public class ClipFragment extends BaseFragment {
    private RecyclerView mClipRv;
    private Context mContext;
    private ArrayList<NewsData> mDataList;
    private LinearLayoutManager mLayoutManager;
    private ClipRvAdapter mClipRvAdapter;

    public ClipFragment(Context context) {
        mContext = context;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_clip, container, false);
        setComponentView(view);
        return view;
    }

    @Override
    public void setComponentView(View v) {
        mClipRv = v.findViewById(R.id.clip_rv);
        mDataList = new ArrayList<>();

        mDataList.add(new NewsData(R.drawable.test, "그대의 쉼표, 제 23대 학생회 ‘Comma’의 회장단을 만나다.", "재학생 인터뷰 · 오현지 기자 · 2019.06.10"));
        mDataList.add(new NewsData(R.drawable.test2,"월드프렌즈 ICT 봉사단 인터뷰 우즈베키스탄&가나편","재학생 인터뷰 · 윤정민 기자 · 2018.12.24"));
        mDataList.add(new NewsData(R.drawable.test3, "한국투자증권 12학번 오민우 동문 인터뷰", "동문 인터뷰 · 박지영 기자 · 2018.12.10"));
        mDataList.add(new NewsData(R.drawable.test4, "ROTC 출신 11학번 서민우 동문인터뷰", "동문 인터뷰 · 김용현 기자 · 2018.10.29"));
        mDataList.add(new NewsData(R.drawable.test5, "Wong Kok Seng 교수님 인터뷰", "교수님 인터뷰 · 송지원 국장 · 2018.09.10"));
        mDataList.add(new NewsData(R.drawable.test6, "한국투자증권 12학번 오민우 동문 인터뷰", "동문 인터뷰 · 박지영 기자 · 2018.12.10"));

        mClipRv = v.findViewById(R.id.clip_rv);
        mLayoutManager  = new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false);
        mClipRv.setLayoutManager(mLayoutManager);
        mClipRvAdapter = new ClipRvAdapter(mDataList, mContext);

        mClipRv.setAdapter(mClipRvAdapter);
    }

    @Override
    public void onClick(View view) {

    }
}
