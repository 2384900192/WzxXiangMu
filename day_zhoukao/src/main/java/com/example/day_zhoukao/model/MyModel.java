package com.example.day_zhoukao.model;

import com.example.day_zhoukao.base.BaseModel;
import com.example.day_zhoukao.bean.DatasBean;
import com.example.day_zhoukao.bean.MyBean;
import com.example.day_zhoukao.callback.ApiServer;
import com.example.day_zhoukao.callback.MyCallBack;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModel extends BaseModel {
    public void getData(final MyCallBack myCallBack){
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiServer.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiServer apiServer = build.create(ApiServer.class);
        Observable<MyBean> data = apiServer.getData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(MyBean myBean) {
                        List<DatasBean> datas = myBean.getData().getDatas();
                        myCallBack.onSuner(datas);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myCallBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
