package com.jzw.mvp.base;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

/**
 * @anthor created by jzw
 * @date 2017/11/23 0023
 * @change
 * @describe describe
 **/
public abstract class BaseActivity extends AppCompatActivity {
    /**
     * 是否可以隐藏软键盘
     */
    private boolean isShouldHideInput = true;
    /**
     * 标记目前界面是否已经调用过setcontentView这个方法，如果子类已经有调用，父类就不调用
     */
    private boolean initContentView = false;
    /**
     * 作用同 initContentView
     */
    private boolean initViews = false;

    public abstract int getLayoutId();

    public abstract void initViews(Bundle savedInstanceState);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!initContentView) {
            setContentView(getLayoutId());
            setInitContentView(true);
        }
        if (!initViews) {
            initViews(savedInstanceState);
            setInitViews(true);
        }
    }

    public void setInitContentView(boolean init) {
        initContentView = init;
    }

    public void setInitViews(boolean init) {
        initViews = init;
    }

    public boolean isInitContentView() {
        return initContentView;
    }

    public boolean isInitViews() {
        return initViews;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            if (isShouldHideInput) {
                // 获得当前得到焦点的View，一般情况下就是EditText（特殊情况就是轨迹求或者实体案件会移动焦点）
                View v = getCurrentFocus();
                if (InputUtil.isShouldHideInput(v, ev)) {
                    InputUtil.hideSoftInput(BaseActivity.this, v.getWindowToken());
                }
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 是否开启 点击输入法之外的地方 自动隐藏软键盘功能，默认是开启的
     *
     * @param hide
     */
    public void setShouldHideInput(boolean hide) {
        this.isShouldHideInput = hide;
    }

    public void startActivity(Class<?> clazz) {
        try {
            Intent intent = new Intent(this, clazz);
            startActivityForResult(intent, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startActivity(Class<?> clazz, int requestCode) {
        try {
            Intent intent = new Intent(this, clazz);
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
            Intent intent = new Intent(this, clazz);
            intent.putExtras(bundle);
            startActivityForResult(intent, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startActivity(Class<?> clazz, Bundle bundle, int requestCode) {
        try {
            Intent intent = new Intent(this, clazz);
            intent.putExtras(bundle);
            startActivityForResult(intent, requestCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
