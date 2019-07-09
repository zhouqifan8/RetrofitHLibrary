package com.zqf.retrofitlibrary.observer;

import org.json.JSONException;

/**
 * <请求返回状态>
 */
interface CallBack<T> {

    /**
     * 成功回调
     *
     * @param action
     * @param value
     */
    void onSuccess(String action, T value);

    /**
     * 失败回调
     *
     * @param action
     * @param code
     * @param msg
     */
    void onError(String action, int code, String msg);

    /**
     * 取消回调
     */
    void onCancel();

    /**
     * 数据转换/解析数据
     *
     * @param tData
     * @return
     */
    T onConvert(T tData) throws JSONException;

}
