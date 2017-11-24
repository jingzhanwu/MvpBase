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
public class Fragment2 extends BaseFragment {
    private String TAG = "Fragment2>>";

    @Override
    public int getLayoutId() {
        return R.layout.fragment2;
    }

    @Override
    public void initView(View rootView) {
        Log.d(TAG, "初始化Fragment2");
    }

    @Override
    public void lazyLoadData() {
        Log.d(TAG, "Fragment2懒加载数据");
        Toast.makeText(getActivity(), "Fragment 2", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        Log.d(TAG, "Fragment2>>isVisibleToUser>>    " + isVisibleToUser);
        super.setUserVisibleHint(isVisibleToUser);
    }
}
