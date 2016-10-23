package com.rex.hwong.openeyes.bean.discovery.detail;

import java.io.Serializable;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 2016/10/22
 * @time 下午10:33
 */

public class DetailItemProvider implements Serializable {
    private String name;
    private String alias;
    private String icon;

    public DetailItemProvider() {
    }

    public DetailItemProvider(String name, String alias, String icon) {
        this.name = name;
        this.alias = alias;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "DetailItemProvider{" +
                "name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
