package com.example.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.zqf.retrofitlibrary.RetrofitHLibrary;
import com.zqf.retrofitlibrary.observer.HttpObserver;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login();
    }

    private void login() {
        Map<String, Object> map = new HashMap<>();
        map.put("mobile", 110);
        map.put("psw", "123");
        RetrofitHLibrary.getRetrofitHttp().post().apiUrl(UrlConstans.LOGIN).addParameter(map)
                .build().request(new HttpObserver<Loginmodel>(this, true) {
            @Override
            public void onSuccess(String action, Loginmodel value) {

            }

            @Override
            protected void isLoginToken() {
                super.isLoginToken();
            }

            @Override
            public void onError(String action, int code, String desc) {
                super.onError(action, code, desc);
                Toast.makeText(MainActivity.this, desc, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
