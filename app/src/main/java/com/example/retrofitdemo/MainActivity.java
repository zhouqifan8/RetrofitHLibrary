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
            public void onSuccess(String tag, Loginmodel response) {

            }

            @Override
            public void onError(String tag, int code, String msg) {
                super.onError(tag, code, msg);
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
