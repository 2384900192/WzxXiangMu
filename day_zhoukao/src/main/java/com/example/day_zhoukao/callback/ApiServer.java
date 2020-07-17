package com.example.day_zhoukao.callback;

import com.example.day_zhoukao.bean.MyBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServer {
        String url="https://www.wanandroid.com/";

        @GET("project/list/1/json?cid=294")
        Observable<MyBean> getData();
}
