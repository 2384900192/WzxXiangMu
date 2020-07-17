package com.example.day_zhoukao.callback;

import com.example.day_zhoukao.bean.DatasBean;
import com.example.day_zhoukao.bean.MyBean;

import java.util.List;

public interface MyCallBack {
    void onSuner(List<DatasBean>  datasBean);
    void onFail(String string);
}
