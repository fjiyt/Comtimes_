package com.comtimes.android.comtimes.src.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.comtimes.android.comtimes.R;
import com.comtimes.android.comtimes.src.main.models.RecentNewsData;

import java.util.ArrayList;

public class RecentNewsRvAdapter extends RecyclerView.Adapter<RecentNewsRvAdapter.ViewHolder>{
    ArrayList<RecentNewsData> dataList;
    Context context;
    RequestManager glideRequestManager;

    public RecentNewsRvAdapter(ArrayList<RecentNewsData> dataList, Context context, RequestManager glideRequestManager){
        this.dataList = dataList;
        this.context = context;
        this.glideRequestManager = glideRequestManager;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recent_news_rv_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        final RecentNewsData data = dataList.get(i);
        viewHolder.title.setText(data.getTitle());
        glideRequestManager.load(data.getNewsImg()).into(viewHolder.newsImg);
        //viewHolder.newsImg.setImageResource(data.getNewsImg()); 그냥 이렇게 하면 이미지 용량이 커서 뻑나요. Glide라는 라이브러리 써서 이미지
        //압축시켜서 load합니다. >> glideRequestManager.load(data.getNewsImg()).into(viewHolder.newsImg);
        //한 번 두코드 둘 다 써서 비교해보세요
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView newsImg;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.main_recent_news_rv_item_title_tv);
            newsImg = itemView.findViewById(R.id.main_recent_news_rv_item_news_iv);
        }
    }
}
