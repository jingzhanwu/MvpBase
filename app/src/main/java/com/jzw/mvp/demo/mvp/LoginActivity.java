package com.jzw.mvp.demo.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.jzw.mvp.base.BaseMvpActivity;
import com.jzw.mvp.demo.R;
import com.jzw.mvp.demo.mvp.presenter.LoginPresenter;
import com.jzw.mvp.demo.mvp.view.ILoginView;

/**
 * @anthor created by jzw
 * @date 2017/11/23 0023
 * @change
 * @describe 使用MVP 模式登陆
 **/
public class LoginActivity extends DSMvpActivity<ILoginView, LoginPresenter> implements ILoginView {
    @Override
    public int getLayoutId() {
        return R.layout.act_login;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        //初始化views
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login("jzw", "123456");
            }
        });

    }

    @Override
    public void showLoadding() {
        //在这里显示加载对话框
    }

    @Override
    public void hideLoadding() {
        //在这里隐藏对话框
    }

    @Override
    public LoginPresenter initPresenter() {
        //初始化presenter
        return new LoginPresenter();
    }

    @Override
    public void loginSuccess(String userid) {
        //登陆成功回掉到这里
        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
    }
}
