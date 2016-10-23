package com.rex.hwong.openeyes.bean.discovery.detail;

import java.io.Serializable;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 2016/10/22
 * @time 下午10:37
 */

public class DetailItemTag implements Serializable {
    private int id;
    private String name;
    private String actionUrl;
    private String adTrack;

    public DetailItemTag() {
    }

    public DetailItemTag(int id, String name, String actionUrl, String adTrack) {
        this.id = id;
        this.name = name;
        this.actionUrl = actionUrl;
        this.adTrack = adTrack;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    public String getAdTrack() {
        return adTrack;
    }

    public void setAdTrack(String adTrack) {
        this.adTrack = adTrack;
    }

    @Override
    public String toString() {
        return "DetailItemTag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", actionUrl='" + actionUrl + '\'' +
                ", adTrack='" + adTrack + '\'' +
                '}';
    }
}
