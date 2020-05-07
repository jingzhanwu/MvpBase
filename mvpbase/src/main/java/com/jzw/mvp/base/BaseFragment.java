package com.jzw.mvp.base;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * @anthor created by jzw
 * @date 2017/11/23 0023
 * @change
 * @describe fragment基类
 **/
public abstract class BaseFragment extends Fragment {
    private boolean isOpenLazyLoad = false;//是否支持懒加载，默认不开启
    private boolean isInitView = false;//是否与View建立起映射关系
    private boolean isVisible = false;
    private boolean isLoaded = false;//是否已经加载过
    private boolean noCacheLoad = false; //是否开启 界面一显示就加载的功能，默认不开启
    public View rootView;

    @SuppressLint("NewApi")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutId(), container, false);
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(rootView);
        isInitView = true;
        if (isVisible) {
            lazyLoad();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isVisible = getUserVisibleHint();
        if (isVisible) {
            lazyLoad();
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden && isResumed()) {
            lazyLoad();
        }
    }

    public abstract int getLayoutId();

    public abstract void initView(View rootView);

    /**
     * 子类实现，适用于需要懒加载模式的情况下的数据请求
     */
    public abstract void lazyLoadData();


    /**
     * 懒加载数据
     */
    private void lazyLoad() {
        if (isOpenLazyLoad()) {
            if (isInitView && (noCacheLoad ? true : !isLoaded)) {
                isLoaded = true;
                lazyLoadData();
            }
        }
    }


    public boolean isOpenLazyLoad() {
        return isOpenLazyLoad;
    }

    /**
     * 是否开启懒加载模式,默认不开启，如果开启懒加载模式，
     * 网络请求数据请在lazyLoadData 这个抽象方法的实现中去做
     * 如果不需要使用懒加载则走正常模式，在initView中去做.没有
     * 开启懒加载模式，即使在lazyLoadData中有操作也不会走这个方法，除非自己在
     * 子类中手动调用
     *
     * @param isOpen
     */
    public void openLazyLoad(boolean isOpen) {
        isOpenLazyLoad = isOpen;
    }

    /**
     * 是否开启 页面不缓存的模式，默认不开启
     * 开启以后，每次页面切换都会加载数据，
     * 只有在开启懒加载模式下生效
     *
     * @return
     */
    public void setCacheLoad(boolean isOpen) {
        this.noCacheLoad = isOpen;
    }

    @Override
    public void onDestroyView() {
        noCacheLoad = false;
        isLoaded = false;
        isInitView = false;
        super.onDestroyView();
    }

    public void startActivity(Class<?> clazz) {
        try {
            Intent intent = new Intent(getActivity(), clazz);
            startActivityForResult(intent, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startActivity(Class<?> clazz, int requestCode) {
        try {
            Intent intent = new Intent(getActivity(), clazz);
            startActivityForResult(intent, requestCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 传入bundle
     *
     * @param clazz
     * @param bundle
     */
    public void startActivity(Class<?> clazz, Bundle bundle) {
        try {
            Intent intent = new Intent(getActivity(), clazz);
            intent.putExtras(bundle);
            startActivityForResult(intent, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startActivity(Class<?> clazz, Bundle bundle, int requestCode) {
        try {
            Intent intent = new Intent(getActivity(), clazz);
            intent.putExtras(bundle);
            startActivityForResult(intent, requestCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
