package com.example.day_zhoukao.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {
    public CompositeDisposable mDisposable=null;

    public void addDisposable(Disposable disposable){
        if (mDisposable==null){
            synchronized (this){
                if (mDisposable==null)
                    mDisposable=new CompositeDisposable();
            }
        }
        mDisposable.add(disposable);
    }

    public void dispose(){
        mDisposable.dispose();
    }
    public void remvoeDisposable(Disposable disposable){
        if (mDisposable!=null){
            mDisposable.addAll(disposable);
        }
    }
}
