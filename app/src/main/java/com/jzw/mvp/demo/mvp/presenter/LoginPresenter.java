package com.jzw.mvp.demo.mvp.presenter;

import com.jzw.mvp.base.presenter.BasePresenter;
import com.jzw.mvp.demo.mvp.modle.LoginModel;
import com.jzw.mvp.demo.mvp.view.ILoginView;

/**
 * @anthor created by jzw
 * @date 2017/11/23 0023
 * @change
 * @describe describe
 **/
public class LoginPresenter extends BasePresenter<ILoginView> {

    private LoginModel modle;

    @Override
    public void init() {
        modle = new LoginModel();
    }

    @Override
    public void release() {
        if (modle != null) {
            modle = null;
        }
    }

    public void login(String user, String pwd) {
        getMvpView().showLoading();

        modle.loginUser(user, pwd);
        getMvpView().loginSuccess(user);

        getMvpView().hideLoading();
    }
}
