package com.rex.hwong.openeyes.bean.discovery.detail;

import java.io.Serializable;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 2016/10/22
 * @time 下午10:34
 */

public class DetailItemCover implements Serializable {
    private String feed;
    private String detail;
    private String blurred;
    private String sharing;

    public DetailItemCover() {
    }

    public DetailItemCover(String feed, String detail, String blurred, String sharing) {
        this.feed = feed;
        this.detail = detail;
        this.blurred = blurred;
        this.sharing = sharing;
    }

    public String getFeed() {
        return feed;
    }

    public void setFeed(String feed) {
        this.feed = feed;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getBlurred() {
        return blurred;
    }

    public void setBlurred(String blurred) {
        this.blurred = blurred;
    }

    public String getSharing() {
        return sharing;
    }

    public void setSharing(String sharing) {
        this.sharing = sharing;
    }

    @Override
    public String toString() {
        return "DetailItemCover{" +
                "feed='" + feed + '\'' +
                ", detail='" + detail + '\'' +
                ", blurred='" + blurred + '\'' +
                ", sharing='" + sharing + '\'' +
                '}';
    }
}
