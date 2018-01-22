package com.jzw.mvp.demo.test;

import com.jzw.dev.http.entry.RspEntry;

import java.util.List;

/**
 * @anthor created by jingzhanwu
 * @date 2017/11/28 0028
 * @change
 * @describe 接口请求基类 data 为对象 { list:[]}
 **/
public class ResultList<T> extends RspEntry {
    private BaseData<T> data;

    public BaseData getData() {
        return data;
    }

    public List<T> getList() {
        if (getData() != null) {
            return getData().getList();
        }
        return null;
    }

    public void setBaseData(BaseData data) {
        this.data = data;
    }

    private class BaseData<H> {
        private Integer total;
        private List<H> list;

        public List<H> getList() {
            return list;
        }

        public void setList(List<H> list) {
            this.list = list;
        }

        public Integer getTotal() {
            return total;
        }
    }
}
