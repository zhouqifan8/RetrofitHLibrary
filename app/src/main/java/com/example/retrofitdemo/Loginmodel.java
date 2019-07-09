package com.example.retrofitdemo;

import com.zqf.retrofitlibrary.model.BaseResponseModel;

public class Loginmodel extends BaseResponseModel<Loginmodel> {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
