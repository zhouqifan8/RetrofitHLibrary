package com.zqf.retrofitlibrary.observer;

import android.content.Context;

import com.zqf.retrofitlibrary.R;
import com.zqf.retrofitlibrary.RetrofitHLibrary;
import com.zqf.retrofitlibrary.RetrofitHttp;
import com.zqf.retrofitlibrary.exception.ApiException;
import com.zqf.retrofitlibrary.exception.ExceptionEngine;
import com.zqf.retrofitlibrary.model.BaseResponseModel;
import com.zqf.retrofitlibrary.utils.LogUtils;
import com.zqf.retrofitlibrary.utils.ThreadUtils;
import com.google.gson.Gson;

import org.json.JSONException;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.annotations.NonNull;

/**
 * Http请求回调
 */
public abstract class BaseHttpObserver<T> extends BaseObserver<T> implements CallBack<T> {
    private BaseResponseModel mResponse;

    public BaseHttpObserver() {
    }

    public BaseHttpObserver(Context context, boolean isDialog, boolean isCabcelble) {
        super(context, isDialog, isCabcelble);
    }

    /**
     * 是否回调成功函数
     */
    private boolean callSuccess = true;

    @Override
    public void onNext(@NonNull T value) {
        super.onNext(value);
        inSuccess(getTag(), value);
    }

    @Override
    public void onError(Throwable e) {
        super.onError(e);
        if (e instanceof ApiException) {
            ApiException exception = (ApiException) e;
            inError(getTag(), exception.getCode(), exception.getMsg());
        } else {
            inError(getTag(), ExceptionEngine.UN_KNOWN_ERROR, RetrofitHLibrary.getAppString(R.string.un_known_error));
        }
    }

    @Override
    public void onCanceled() {
        onCanceledLogic();
    }

    /**
     * 请求成功
     *
     * @param tag
     * @param response
     */
    private void inSuccess(String tag, T response) {
        T result = null;
        mResponse = new Gson().fromJson((String) response, BaseResponseModel.class);
        int code = mResponse.getCode();
        switch (code) {
            case 200://成功
                try {
                    result = onConvert(new Gson().fromJson((String) response, getTypeClass()));
                    callSuccess = true;
                } catch (JSONException e) {
                    callSuccess = false;
                    onError(getTag(), ExceptionEngine.ANALYTIC_CLIENT_DATA_ERROR, RetrofitHLibrary.getAppString(R.string.data_parsing_error));
                }
                if (callSuccess && response != null) {
                    onSuccess(tag, result);
                }
                break;
            case 222://token过期、异地登录，跳转登录页面重新登录
                isLoginToken();
                break;
            default://统一为错误处理
                onError(getTag(), code, mResponse.getMsg());
                break;
        }
    }

    @Override
    public void isLoginToken() {

    }

    /**
     * 请求出错
     *
     * @param tag
     * @param code
     * @param msg
     */
    private void inError(String tag, int code, String msg) {
        onError(tag, code, msg);
    }

    /**
     * Http被取消回调处理逻辑
     */
    private void onCanceledLogic() {
        if (!ThreadUtils.isMainThread()) {
            RetrofitHttp.Configure.get().getHandler().post(this::inCancel);
        } else {
            inCancel();
        }
    }

    /**
     * 请求取消
     */
    private void inCancel() {
        onCancel();
    }

    /**
     * 取消回调
     * 如果有特殊处理需重写
     */
    public void onCancel() {
        LogUtils.d(RetrofitHLibrary.getAppString(R.string.request_cancelled));
    }

    /**
     * 获取当前类泛型
     */
    private Type getTypeClass() {
        Type type = null;
        ParameterizedType ptClass = (ParameterizedType) getClass().getGenericSuperclass();
        if (ptClass != null) {
            type = ptClass.getActualTypeArguments()[0];
            LogUtils.d("当前类泛型:" + type);
        }
        return type;
    }

}
