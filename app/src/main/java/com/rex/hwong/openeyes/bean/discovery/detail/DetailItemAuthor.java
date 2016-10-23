package com.rex.hwong.openeyes.bean.discovery.detail;

import java.io.Serializable;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 2016/10/22
 * @time 下午10:59
 */

public class DetailItemAuthor implements Serializable{
    private int id;
    private int videoNum;
    private long latestReleaseTime;
    private String icon;
    private String name;
    private String description;
    private String adTrack;
    private String link;

    public DetailItemAuthor() {
    }

    public DetailItemAuthor(int id, int videoNum, long latestReleaseTime, String icon, String name, String description, String adTrack, String link) {
        this.id = id;
        this.videoNum = videoNum;
        this.latestReleaseTime = latestReleaseTime;
        this.icon = icon;
        this.name = name;
        this.description = description;
        this.adTrack = adTrack;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVideoNum() {
        return videoNum;
    }

    public void setVideoNum(int videoNum) {
        this.videoNum = videoNum;
    }

    public long getLatestReleaseTime() {
        return latestReleaseTime;
    }

    public void setLatestReleaseTime(long latestReleaseTime) {
        this.latestReleaseTime = latestReleaseTime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdTrack() {
        return adTrack;
    }

    public void setAdTrack(String adTrack) {
        this.adTrack = adTrack;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "DetailItemAuthor{" +
                "id=" + id +
                ", videoNum=" + videoNum +
                ", latestReleaseTime=" + latestReleaseTime +
                ", icon='" + icon + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", adTrack='" + adTrack + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
