package com.rex.hwong.openeyes.bean.discovery.detail;

import java.io.Serializable;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 2016/10/22
 * @time 下午11:03
 */

public class DetailItemPlayInfo implements Serializable {
    private int height;
    private int width;
    private String name;
    private String type;
    private String url;

    public DetailItemPlayInfo() {
    }

    public DetailItemPlayInfo(int height, int width, String name, String type, String url) {
        this.height = height;
        this.width = width;
        this.name = name;
        this.type = type;
        this.url = url;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "DetailItemPlayInfo{" +
                "height=" + height +
                ", width=" + width +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
