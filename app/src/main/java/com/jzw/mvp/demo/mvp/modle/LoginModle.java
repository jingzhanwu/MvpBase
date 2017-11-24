package com.jzw.mvp.demo.mvp.modle;

import android.app.Activity;

import com.jzw.mvp.base.modle.BaseModle;
import com.jzw.mvp.base.presenter.BasePresenter;

/**
 * @company 上海道枢信息科技-->
 * @anthor created by Administrator
 * @date 2017/11/23 0023
 * @change
 * @describe describe
 **/
public class LoginModle extends BaseModle {
    @Override
    public Activity getView() {
        return null;
    }

    @Override
    public BasePresenter getPresenter() {
        return null;
    }

    public void loginUser(String userId, String pwd) {
        System.out.println("登陆》》");
    }
}
