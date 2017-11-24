package com.jzw.mvp.base.presenter;

/**
 * 由于presenter会持有Activity（View）的应用，可能会造成内存泄漏，这个接口负责管理这一过程
 * MVP 架构中管理presenter的生命周期，负责创建销毁presenter
 * Created by 景占午 on 2017/10/19 0019.
 */

public interface IPresenter<V> {
    void attachView(V view);

    void detachView();
}
