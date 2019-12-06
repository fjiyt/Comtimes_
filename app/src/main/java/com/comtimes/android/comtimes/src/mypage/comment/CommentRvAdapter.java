package com.comtimes.android.comtimes.src.mypage.comment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.comtimes.android.comtimes.R;

import java.util.ArrayList;

public class CommentRvAdapter extends RecyclerView.Adapter<CommentRvAdapter.ViewHolder>{
    ArrayList<NewsData> mDataList;
    Context mContext;

    public CommentRvAdapter(ArrayList<NewsData> dataList, Context context) {
        this.mDataList = dataList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_news_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        NewsData data = mDataList.get(i);
        holder.ThumbnailIv.setImageResource(data.getThumbnail());
        holder.titleTv.setText(data.getTitle());
        holder.subTitleTv.setText(data.getSubTitle());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ThumbnailIv;
        TextView titleTv, subTitleTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ThumbnailIv = itemView.findViewById(R.id.news_list_rv_item_thumbnail_rv);
            titleTv = itemView.findViewById(R.id.news_list_rv_item_title_tv);
            subTitleTv = itemView.findViewById(R.id.news_list_rv_item_subtitle_tv);
        }
    }
}
