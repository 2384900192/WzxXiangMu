package com.example.day10_lianxice.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day10_lianxice.R;
import com.example.day10_lianxice.bean.MyBean;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    Context context;
    List<MyBean.DataBean.DatasBean> list;
    final static int BACT_1=0;
    final static int BACT_2=1;

    public MyAdapter(Context context, List<MyBean.DataBean.DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (i){
            case 0:
                View inflate = LayoutInflater.from(context).inflate(R.layout.activity_item, viewGroup, false);
                return new ViewHolder1(inflate);
            case 1:
                View inflate1 = LayoutInflater.from(context).inflate(R.layout.activity_item2, viewGroup, false);
                return new ViewHolder2(inflate1);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder1 extends RecyclerView.ViewHolder {

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
        }
    }
    class ViewHolder2 extends RecyclerView.ViewHolder {

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
        }
    }
}
