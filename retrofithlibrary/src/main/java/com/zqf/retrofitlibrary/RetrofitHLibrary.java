package com.zqf.retrofitlibrary;

import android.app.Application;
import android.support.annotation.StringRes;

import com.zqf.retrofitlibrary.utils.LogUtils;

public class RetrofitHLibrary {
    RetrofitHLibrary() {
        throw new IllegalStateException("RetrofitLibrary class");
    }

    private static Application mApplication;
    private static RetrofitHttp.Builder mHttpBuilder;
    private static RetrofitHttp.Configure mHttpConfigure;

    public static void init(Application application, String baseUrl) {
        try {
            if (application != null) {
                mApplication = application;
                RetrofitHttp.Configure.get().init(application).baseUrl(baseUrl);
                mHttpBuilder = new RetrofitHttp.Builder().getInstance();
            }
        } catch (NullPointerException e) {
            LogUtils.w(e);
        }
    }

    /**
     * 获取初始化的Retrofit
     *
     * @return
     */
    public static RetrofitHttp.Builder getRetrofitHttp() {
        if (mHttpBuilder == null)
            mHttpBuilder = new RetrofitHttp.Builder().getInstance();
        mHttpBuilder.clear();
        return mHttpBuilder;
    }

    /**
     * 初始化Configure
     * 配置Configure
     * 设置是否显示日志、设置超时时间等
     *
     * @return
     */
    public static RetrofitHttp.Configure getmHttpConfigure() {
        if (mHttpConfigure == null)
            mHttpConfigure = new RetrofitHttp.Configure();
        return mHttpConfigure;
    }

    /**
     * 退出应用，清理内存
     */
    public static void onDestory() {
        mHttpBuilder.clear();
        RequestManagerImpl.getInstance().cancelAll();
    }

    public static String getAppString(@StringRes int resId) {
        return mApplication.getString(resId);
    }

    public static Application getApplication() {
        return mApplication;
    }
}
