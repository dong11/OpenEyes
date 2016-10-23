package com.rex.hwong.openeyes.bean.discovery.detail;

import java.io.Serializable;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 2016/10/22
 * @time 下午10:35
 */

public class DetailItemWebUrl implements Serializable {
    private String raw;
    private String forWeibo;

    public DetailItemWebUrl() {
    }

    public DetailItemWebUrl(String raw, String forWeibo) {
        this.raw = raw;
        this.forWeibo = forWeibo;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getForWeibo() {
        return forWeibo;
    }

    public void setForWeibo(String forWeibo) {
        this.forWeibo = forWeibo;
    }

    @Override
    public String toString() {
        return "DetailItemWebUrl{" +
                "raw='" + raw + '\'' +
                ", forWeibo='" + forWeibo + '\'' +
                '}';
    }
}
