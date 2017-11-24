package com.jzw.mvp.demo.fragmeng;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.jzw.mvp.base.BaseFragment;
import com.jzw.mvp.demo.R;

/**
 * @anthor created by jzw
 * @date 2017/11/24 0024
 * @change
 * @describe describe
 **/
public class Fragment3 extends BaseFragment {
    private String TAG = "Fragment3>>";

    @Override
    public int getLayoutId() {
        return R.layout.fragment3;
    }

    @Override
    public void initView(View rootView) {
        Log.d(TAG, "初始化Fragment3");
    }

    @Override
    public void lazyLoadData() {
        Log.d(TAG, "Fragment3懒加载数据");
        Toast.makeText(getActivity(), "Fragment 3", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(TAG, "Fragment3>>isVisibleToUser>>    " + isVisibleToUser);
    }
}
