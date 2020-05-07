package com.jzw.mvp.base;


import android.os.Bundle;
import androidx.annotation.Nullable;

import com.jzw.mvp.base.presenter.BasePresenter;

/**
 * @anthor created by jzw
 * @date 2017/11/23 0023
 * @change
 * @describe 实现MVP架构的基类，使用者只需继承即可
 **/
public abstract class BaseMvpActivity<V, P extends BasePresenter<V>> extends BaseActivity {
    public P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        presenter = initPresenter();
        if (presenter != null) {
            presenter.attachView((V) this);
        }
        super.onCreate(savedInstanceState);
    }

    public abstract P initPresenter();

    @Override
    protected void onDestroy() {
        if (presenter != null) {
            presenter.detachView();
            presenter = null;
        }
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
