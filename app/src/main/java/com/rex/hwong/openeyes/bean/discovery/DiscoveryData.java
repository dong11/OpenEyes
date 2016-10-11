package com.rex.hwong.openeyes.bean.discovery;

import java.util.List;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 16/10/10
 * @time 下午5:53
 */

public class DiscoveryData {
    private String type;
    private DiscoveryItem data;

    public DiscoveryData() {
    }

    public DiscoveryData(String type, DiscoveryItem data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DiscoveryItem getData() {
        return data;
    }

    public void setData(DiscoveryItem data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DiscoveryData{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
