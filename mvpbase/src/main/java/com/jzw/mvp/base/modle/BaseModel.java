package com.jzw.mvp.base.modle;

import android.app.Activity;

import com.jzw.mvp.base.presenter.BasePresenter;


/**
 * Created by 景占午 on 2017/10/19 0019.
 */

public abstract class BaseModle {
    /**
     * 获得当前依赖的view，即activity，可以为空,具体看子类的实现
     *
     * @return
     */
    public abstract Activity getView();

    /**
     * 获得当前依赖的presenter，可以为空,具体看子类的实现
     *
     * @return
     */
    public abstract BasePresenter getPresenter();
}
