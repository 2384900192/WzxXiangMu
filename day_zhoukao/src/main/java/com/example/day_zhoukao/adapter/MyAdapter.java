package com.example.day_zhoukao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.day_zhoukao.R;
import com.example.day_zhoukao.bean.DatasBean;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    Context context;
    List<DatasBean> datasBeans;

    public MyAdapter(Context context, List<DatasBean> datasBeans) {
        this.context = context;
        this.datasBeans = datasBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.activity_item, viewGroup, false);
        return new ViewHolder1(inflate);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        DatasBean datasBean = datasBeans.get(i);
        ViewHolder1 viewHolder1= (ViewHolder1) viewHolder;
        viewHolder1.mTitleTv.setText(datasBean.getTitle());
    }

    @Override
    public int getItemCount() {
        return datasBeans.size();
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
         TextView mTitleTv;
        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            mTitleTv = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
