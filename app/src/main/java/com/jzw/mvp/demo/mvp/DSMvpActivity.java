package com.jzw.mvp.demo.mvp;

import android.os.Bundle;

import com.jzw.mvp.base.BaseMvpActivity;
import com.jzw.mvp.base.presenter.BasePresenter;

/**
 * @company 上海道枢信息科技-->
 * @anthor created by Administrator
 * @date 2017/12/1 0001
 * @change
 * @describe describe
 **/
public abstract class DSMvpActivity<V, P extends BasePresenter<V>> extends BaseMvpActivity<V,P> {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(getLayoutId());
        //加入butterKnife
       // ButterKnife.bind(this);
        initViews(savedInstanceState);
        setInitContentView(true);
        setInitViews(true);
        super.onCreate(savedInstanceState);
    }
}
