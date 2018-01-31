package com.jzw.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.jzw.mvp.base.presenter.BasePresenter;


/**
 * @anthor created by jzw
 * @date 2017/11/24 0024
 * @change
 * @describe describe
 **/
public abstract class BaseMvpFragment<V, P extends BasePresenter<V>> extends BaseFragment {
    public P presenter;

    public abstract P initPresenter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        presenter = initPresenter();
        if (presenter != null) {
            presenter.attachView((V) this);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDetach() {
        if (presenter != null) {
            presenter.detachView();
            presenter = null;
        }
        super.onDetach();
    }
}
