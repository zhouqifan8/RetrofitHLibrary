package com.zqf.retrofitlibrary.observer;


/**
 * <页面网络加载提示基础公共功能抽象>
 */
public interface ProgressDialogObserver {
    /**
     * 网络请求加载框
     */
    void showProgressDialog();

    /**
     * 隐藏网络请求加载框
     */
    void hideProgressDialog();

    /**
     * 取消订阅
     */
    void onCancleProgress();
}
