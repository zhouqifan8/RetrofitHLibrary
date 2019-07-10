package com.zqf.retrofitlibrary.model;

public class BaseResponseModel<T> {
    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public BaseResponseModel<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public BaseResponseModel<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public BaseResponseModel<T> setData(T data) {
        this.data = data;
        return this;
    }
}
