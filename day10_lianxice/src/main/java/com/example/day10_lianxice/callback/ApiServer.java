package com.example.day10_lianxice.callback;

import com.example.day10_lianxice.bean.MyBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServer {
    String url="https://www.wanandroid.com/";

    @GET("project/list/1/json?cid=294")
    Observable<MyBean> getData();
}
