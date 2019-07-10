package com.zqf.retrofitlibrary.observer;

import org.json.JSONException;

/**
 * <请求返回状态>
 */
interface CallBack<T> {

    /**
     * 成功回调
     *
     * @param tag
     * @param response
     */
    void onSuccess(String tag, T response);

    /**
     * 失败回调
     *
     * @param tag
     * @param code
     * @param msg
     */
    void onError(String tag, int code, String msg);

    void isLoginToken();

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
