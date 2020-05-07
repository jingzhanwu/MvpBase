package com.jzw.mvp.base.view;

/**
 * MVP中 view的接口基类，所有的view的继承这个接口
 * 这个接口中定义一些View层公共的接口方法
 * Created by 景占午 on 2017/10/19 0019.
 */

public interface BaseView {
    /**
     * 显示加载对话框
     */
    void showLoading();

    /**
     * 隐藏加载对话框
     */
    void hideLoading();
}
