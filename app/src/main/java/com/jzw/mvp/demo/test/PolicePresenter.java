package com.jzw.mvp.demo.test;

import android.util.Log;

import com.jzw.dev.http.HttpManager;
import com.jzw.dev.http.callback.OnRequestListener;
import com.jzw.mvp.base.presenter.BasePresenter;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * 警情列表获取处理
 * Created by 景占午 on 2017/10/20 0020.
 */

public class PolicePresenter extends BasePresenter<IPoliceView> {
    private IPoliceView policeView;


    @Override
    public void init() {
        policeView = getMvpView();
    }

    @Override
    public void release() {
    }

    public void getPoliceList(Integer status, Integer pageNum, Integer pageSize) {

        JSONObject json = new JSONObject();
        try {
            json.put("start", pageNum);
            json.put("size", pageSize);
            if (status > 0) {
                json.put("alarmStatus", status);
            }
        } catch (JSONException e) {
            Log.e("ds-police", e.getMessage());
            policeView.onGetPoliceFaild("参数异常");
            return;
        }

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json.toString());
        Call<ResultList<DispatchInfo>> call = HttpManager.get().getApiService(ApiService.class).getDispatchList(body);

        HttpManager.get().request(call, new OnRequestListener<ResultList<DispatchInfo>>(getContext()) {
            @Override
            public void onSuccess(ResultList<DispatchInfo> info) {

                if (info != null) {
                    policeView.onGetPoliceSuccess(info.getList());
                } else {
                    policeView.onGetPoliceFaild("获取内容失败");
                }
            }

            @Override
            public void onFaild(int code, String msg) {

                System.out.println("信息》" + msg + "》》》" + policeView);
                policeView.onGetPoliceFaild(msg);
            }
        });
    }
}
