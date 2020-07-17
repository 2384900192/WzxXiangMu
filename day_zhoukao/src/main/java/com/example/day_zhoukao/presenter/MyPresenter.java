package com.example.day_zhoukao.presenter;

import com.example.day_zhoukao.base.BasePresenter;
import com.example.day_zhoukao.bean.DatasBean;
import com.example.day_zhoukao.bean.MyBean;
import com.example.day_zhoukao.callback.MyCallBack;
import com.example.day_zhoukao.model.MyModel;
import com.example.day_zhoukao.view.MyView;

import java.util.List;

public class MyPresenter extends BasePresenter<MyView> implements MyCallBack {

    private MyModel myModel;

    @Override
    protected void initPresen() {
        myModel = new MyModel();
        addModel(myModel);
    }

    public void setString(){
        myModel.getData(this);
    }

    @Override
    public void onSuner(List<DatasBean> datasBean) {
        mView.setData(datasBean);
    }

    @Override
    public void onFail(String string) {
        mView.showToast(string);
    }
}
