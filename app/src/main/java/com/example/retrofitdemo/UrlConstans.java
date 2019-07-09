package com.example.retrofitdemo;

/**
 * <网络请求url地址>
 */
public class UrlConstans {

    UrlConstans() {
        throw new IllegalStateException("UrlConstans class");
    }

    /**
     * 服务器地址
     */
    public static final String DEF_TEST_SERVER = "http://183.129.178.44:8320/klApp/";//测试环境


    /**
     * 用户登陆
     */
    public static final String LOGIN = "user/loginByUserNamePassword";
    public static final String LIST = "messageCenter/listMessage";
}
