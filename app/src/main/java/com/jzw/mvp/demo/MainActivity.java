package com.jzw.mvp.demo;

import android.os.Bundle;
import android.view.View;

import com.jzw.mvp.base.BaseActivity;
import com.jzw.mvp.demo.mvp.LoginActivity;

public class MainActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

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
