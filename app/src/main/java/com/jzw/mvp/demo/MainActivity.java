package com.jzw.mvp.demo;

import android.os.Bundle;
import android.view.View;

import com.jzw.dev.http.HttpConfig;
import com.jzw.mvp.base.BaseActivity;
import com.jzw.mvp.demo.mvp.LoginActivity;
import com.jzw.mvp.demo.test.TestActivity;

public class MainActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        HttpConfig.init()
                .setBaseUrl("http://192.168.0.129:8096")
                .setTimeOut(10)
                .create();

        findViewById(R.id.btn_test_mvp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(TestActivity.class);
            }
        });

        findViewById(R.id.btn_mvp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(LoginActivity.class);
            }
        });

        findViewById(R.id.btn_frgment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(LazyFragmentActivity.class);
            }
        });


    }
}
