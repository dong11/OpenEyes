package com.rex.hwong.openeyes.bean.discovery.detail;

import java.io.Serializable;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 2016/10/22
 * @time 下午10:26
 */

public class DetailData implements Serializable{
    private String type;
    private DetailItem data;

    public DetailData() {
    }

    public DetailData(String type, DetailItem data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DetailItem getData() {
        return data;
    }

    public void setData(DetailItem data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DetailData{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
