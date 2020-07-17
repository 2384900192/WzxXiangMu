package com.example.day_zhoukao.base;

import java.util.ArrayList;

public abstract class BasePresenter<V extends BaseView> {
    public V mView;
    public ArrayList<BaseModel> models=new ArrayList<>();
    public BasePresenter(){
        initPresen();
    }

    protected abstract void initPresen();
    public void addModel(BaseModel baseModel){
        models.add(baseModel);
    }
    public void bindView(V v){
        mView=v;
    }
    public void dispory(){
        mView=null;
        for (int i = 0; i < models.size(); i++) {
            models.get(i).dispose();
        }
    }
}
