package com.zqf.retrofitlibrary.observer;

import android.content.Context;

import com.zqf.retrofitlibrary.RetrofitHLibrary;
import com.zqf.retrofitlibrary.dialog.UITipDialog;
import com.zqf.retrofitlibrary.model.BaseResponseModel;

/**
 * 根据业务进一步封装
 */
public abstract class HttpObserver<T> extends BaseHttpObserver<T> {

    private Context mContext;
    private BaseResponseModel mResponse;

    public HttpObserver() {
    }

    public HttpObserver(Context context, boolean isDialog) {
        this(context, isDialog, false);
    }

    /**
     * @param context
     * @param isDialog    是否显示加载进度对话框
     * @param isCabcelble 当返回键按下是否关闭加载进度对话框
     */
    public HttpObserver(Context context, boolean isDialog, boolean isCabcelble) {
        super(context, isDialog, isCabcelble);
        this.mContext = context;
    }

    @Override
    public T onConvert(T tData) {
        T t = null;
        mResponse = (BaseResponseModel) tData;
        t = (T) mResponse.getData();
        return t;
    }

    /**
     * 网络请求的错误信息
     * 如果有特殊处理需重写
     *
     * @param tag  区分不同事件
     * @param code 错误码
     * @param msg  错误信息
     */
    public void onError(String tag, int code, String msg) {
        if (RetrofitHLibrary.getmHttpConfigure().isShowTipDialog())
            UITipDialog.showFall(mContext, msg);
    }


}
