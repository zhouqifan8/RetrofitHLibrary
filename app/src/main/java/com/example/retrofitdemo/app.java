package com.example.retrofitdemo;

import android.app.Application;

import com.zqf.retrofitlibrary.RetrofitHLibrary;

public class app extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitHLibrary.init(this, UrlConstans.DEF_TEST_SERVER);//初始化
        RetrofitHLibrary.getmHttpConfigure().showLog(true);//设置开启日志，（默认为开启，上线时设为false）
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        RetrofitHLibrary.onDestory();
    }
}
