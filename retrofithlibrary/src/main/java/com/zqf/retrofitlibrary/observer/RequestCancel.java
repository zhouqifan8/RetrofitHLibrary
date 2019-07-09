package com.zqf.retrofitlibrary.observer;

/**
 * 请求取消接口
 */
interface RequestCancel {

    /**
     * 取消请求
     */
    void cancel();

    /**
     * 请求被取消
     */
    void onCanceled();
}
