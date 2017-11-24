package com.jzw.mvp.base.presenter;

import android.app.Activity;
import android.app.Fragment;

import java.lang.ref.WeakReference;
import java.util.MissingFormatArgumentException;

/**
 * MVP 架构中的Presenter的基类，所有的presenter都继承这个类
 * Created by 景占午 on 2017/10/19 0019.
 */

public abstract class BasePresenter<V> implements IPresenter<V> {

    private V mView;

    /**
     * 一旦presenter和View绑定后就调用初始化方法
     *
     * @param view
     */
    @Override
    public void attachView(V view) {
        this.mView = view;
        checkViewAttach();
        init();
    }

    @Override
    public void detachView() {
        release();
        mView = null;
    }

    public Activity getContext() {
        if (mView != null) {
            if (mView instanceof Activity) {
                return (Activity) mView;
            } else if (mView instanceof Fragment) {
                return ((Fragment) mView).getActivity();
            }
        }
        return null;
    }

    /**
     * 初始化presenter需要的一些全局对象，检查是否与View有绑定
     */
    public abstract void init();

    /**
     * 最后释放一些初始化的资源，子类实现
     */
    public abstract void release();

    public boolean isAttachView() {
        return mView != null;
    }

    public V getMvpView() {
        return mView;
    }


    /**
     * 检查view和presenter是否连接
     */
    public void checkViewAttach() {
        if (!isAttachView()) {
            throw new MvpViewNotAttachedException();
        }
    }

    /**
     * 自定义异常
     */
    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Mvp View Not Attached Exception, please call attachView function first");
        }
    }
}
