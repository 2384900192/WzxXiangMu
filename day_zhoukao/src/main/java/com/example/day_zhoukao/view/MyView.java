package com.example.day_zhoukao.view;

import com.example.day_zhoukao.base.BaseView;
import com.example.day_zhoukao.bean.DatasBean;
import com.example.day_zhoukao.bean.MyBean;

import java.util.List;

public interface MyView extends BaseView {
    void setData(List<DatasBean> data);
}
