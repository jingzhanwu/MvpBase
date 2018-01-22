package com.jzw.mvp.demo.test;


import java.util.List;

/**
 * Created by 景占午 on 2017/10/20 0020.
 */

public interface IPoliceView {
    /**
     *
     * @param info
     */
    void onGetPoliceSuccess(List<DispatchInfo> info);

    /**
     *
     * @param msg
     */

    void onGetPoliceFaild(String msg);
}
