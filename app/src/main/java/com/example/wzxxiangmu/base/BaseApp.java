package com.example.wzxxiangmu.base;

import android.app.Application;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.Logger;

public class BaseApp extends Application {

       		// 初始化 JPush
    @Override
    public void onCreate() {
        super.onCreate();
        //签名
        //fe284fb3bd1f929dc06074f932aaa3cf
        //有盟
        //5f0fc543978eea08cad0d404
        UMConfigure.init(this,"5f0fc543978eea08cad0d404"
                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");


        //极光
        //AppKey
        //2a63bb4197177b0b23d528ef


        //App Key：2785195816
        //App Secret：4827419293a887e7fd0a6dd5add2a719//微博
        PlatformConfig.setSinaWeibo("2785195816", "4827419293a887e7fd0a6dd5add2a719","http://sns.whalecloud.com");
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        //豆瓣RENREN平台目前只能在服务器端配置
        PlatformConfig.setYixin("yxc0614e80c9304c11b0391514d09f13bf");
        PlatformConfig.setTwitter("3aIN7fuF685MuZ7jtXkQxalyi", "MK6FEYG63eWcpDFgRYw4w9puJhzDl0tyuqWjZ3M7XJuuG7mMbO");
        PlatformConfig.setAlipay("2015111700822536");
        PlatformConfig.setLaiwang("laiwangd497e70d4", "d497e70d4c3e4efeab1381476bac4c5e");
        PlatformConfig.setPinterest("1439206");
        PlatformConfig.setKakao("e4f60e065048eb031e235c806b31c70f");
        PlatformConfig.setDing("dingoalmlnohc0wggfedpk");
        PlatformConfig.setVKontakte("5764965","5My6SNliAaLxEm3Lyd9J");
        PlatformConfig.setDropbox("oz8v5apet3arcdy","h7p2pjbzkkxt02a");
    }

}
