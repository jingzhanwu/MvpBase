package com.jzw.mvp.demo.test;

import android.os.Bundle;
import android.widget.TextView;

import com.jzw.mvp.base.BaseMvpActivity;
import com.jzw.mvp.demo.R;

import java.util.List;

/**
 * @company 上海道枢信息科技-->
 * @anthor created by Administrator
 * @date 2018/1/14 0014
 * @change
 * @describe describe
 **/
public class TestActivity extends BaseMvpActivity<IPoliceView, PolicePresenter> implements IPoliceView {
    private TextView textView;

    @Override
    public PolicePresenter initPresenter() {
        return new PolicePresenter();
    }

    @Override
    public int getLayoutId() {
        return R.layout.act_test;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        textView = findViewById(R.id.tv_text);
        presenter.getPoliceList(0, 1, 20);
    }

    @Override
    public void onGetPoliceSuccess(List<DispatchInfo> info) {
        textView.setText(info.get(0).getDispatchOfficerName());
    }

    @Override
    public void onGetPoliceFaild(String msg) {
        textView.setText(msg);
    }

}
