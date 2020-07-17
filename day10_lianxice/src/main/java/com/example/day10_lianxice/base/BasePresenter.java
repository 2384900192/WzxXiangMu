package com.example.day10_lianxice.base;

import com.example.day10_lianxice.bean.MyBean;

import java.util.ArrayList;

public  abstract class BasePresenter<V extends BaseView> {
    public V mView;
    private ArrayList<BaseModel> myBeans=new ArrayList<>();
    public BasePresenter(){
        initPresent();
    }

    protected abstract void initPresent();
    public void addModel(BaseModel model){
        myBeans.add(model);
    }
    public void bindView(V v){
        mView=v;
    }
    public void destroy(){
        mView=null;
        for (int i = 0; i < myBeans.size(); i++) {
            myBeans.get(i).dispose();
        }
    }
}
