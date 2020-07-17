package com.example.day_zhoukao.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.day_zhoukao.R;
import com.example.day_zhoukao.base.BaseApp;
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
       final DatasBean datasBean = datasBeans.get(i);
        final ViewHolder1 viewHolder1= (ViewHolder1) viewHolder;
        viewHolder1.mTitleTv.setText(datasBean.getTitle());
        viewHolder1.mImgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(datasBean.getIsChecked()){
                    datasBean.setIsChecked(false);
                    //则更新数据库
                    BaseApp.getInstance().getDaoSession().delete(datasBean);
                    //并给收藏图片
                    viewHolder1.mImgview.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.heart_unselect));

                }else{
                    datasBean.setIsChecked(true);
                    BaseApp.getInstance().getDaoSession().insertOrReplace(datasBean);
                    viewHolder1.mImgview.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.heart_select));
                }
            }
        });
        if (datasBean.getIsChecked() == true) {
            viewHolder1.mImgview.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.heart_select));

            /*holder1.iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    datasBean.setIsChecked(false);
                    BaseApp.getInstance().getDaoSession().insertOrReplace(datasBean);
                    holder1.iv.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.heart_unselect));
                    //取消保存从数据库中删除
                    BaseApp.getInstance().getDaoSession().getDatasBeanDao().delete(datasBean);
                }
            });*/

        }else{
            viewHolder1.mImgview.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.heart_unselect));

        }
    }

    @Override
    public int getItemCount() {
        return datasBeans.size();
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
         TextView mTitleTv;
         ImageView mImgview;
        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            mTitleTv = (TextView) itemView.findViewById(R.id.tv_title);
            mImgview = (ImageView) itemView.findViewById(R.id.tv_imgview);
        }
    }
}
