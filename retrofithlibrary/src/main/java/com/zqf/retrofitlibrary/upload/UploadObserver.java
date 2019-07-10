package com.zqf.retrofitlibrary.upload;

import android.content.Context;

import com.zqf.retrofitlibrary.RetrofitHLibrary;
import com.zqf.retrofitlibrary.dialog.UITipDialog;
import com.zqf.retrofitlibrary.observer.BaseHttpObserver;

import java.io.File;

/**
 * 上传回调接口
 */
public abstract class UploadObserver<T> extends BaseHttpObserver<T> implements UploadProgressCallback {

    public UploadObserver() {
    }

    public UploadObserver(Context context, boolean isDialog, boolean isCabcelble) {
        super(context, isDialog, isCabcelble);
    }

    @Override
    public void progress(File file, long currentSize, long totalSize, float progress, int currentIndex, int totalFile) {
        onProgress(file, currentSize, totalSize, progress, currentIndex, totalFile);
    }

    /**
     * 上传回调
     *
     * @param file
     * @param currentSize
     * @param totalSize
     * @param progress
     * @param currentIndex
     * @param totalFile
     */
    public abstract void onProgress(File file, long currentSize, long totalSize, float progress, int currentIndex, int totalFile);

    /**
     * 失败回调
     *
     * @param action
     * @param code
     * @param desc
     */
    public void onError(String action, int code, String desc) {
        if (RetrofitHLibrary.getmHttpConfigure().isShowTipDialog())
            UITipDialog.showFall(RetrofitHLibrary.getApplication(), desc);
    }

}
