package com.rex.hwong.openeyes.bean.discovery.detail;

import java.io.Serializable;
import java.util.List;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 2016/10/22
 * @time 下午10:28
 */

public class DetailItem implements Serializable{
    private String dataType;
    private String title;
    private String description;
    private String category;
    private DetailItemAuthor author;
    private List<DetailItemPlayInfo> playInfo;
    private String playUrl;
    private String campaign;
    private String waterMarks;
    private String adTrack;
    private String type;
    private String shareAdTrack;
    private String webAdTrack;
    private String favoriteAdTrack;
    private boolean collected;
    private boolean played;
    private int id;
    private int duration;
    private int idx;
    private long date;
    private long releaseTime;
    private DetailItemProvider provider;
    private DetailItemCover cover;
    private List<DetailItemTag> tags;
    private DetailItemWebUrl webUrl;
    private DetailItemConsumption consumption;

    public DetailItem() {
    }

    public DetailItem(String dataType, String title, String description, String category, DetailItemAuthor author, List<DetailItemPlayInfo> playInfo, String playUrl, String campaign, String waterMarks, String adTrack, String type, String shareAdTrack, String webAdTrack, String favoriteAdTrack, boolean collected, boolean played, int id, int duration, int idx, long date, long releaseTime, DetailItemProvider provider, DetailItemCover cover, List<DetailItemTag> tags, DetailItemWebUrl webUrl, DetailItemConsumption consumption) {
        this.dataType = dataType;
        this.title = title;
        this.description = description;
        this.category = category;
        this.author = author;
        this.playInfo = playInfo;
        this.playUrl = playUrl;
        this.campaign = campaign;
        this.waterMarks = waterMarks;
        this.adTrack = adTrack;
        this.type = type;
        this.shareAdTrack = shareAdTrack;
        this.webAdTrack = webAdTrack;
        this.favoriteAdTrack = favoriteAdTrack;
        this.collected = collected;
        this.played = played;
        this.id = id;
        this.duration = duration;
        this.idx = idx;
        this.date = date;
        this.releaseTime = releaseTime;
        this.provider = provider;
        this.cover = cover;
        this.tags = tags;
        this.webUrl = webUrl;
        this.consumption = consumption;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public DetailItemAuthor getAuthor() {
        return author;
    }

    public void setAuthor(DetailItemAuthor author) {
        this.author = author;
    }

    public List<DetailItemPlayInfo> getPlayInfo() {
        return playInfo;
    }

    public void setPlayInfo(List<DetailItemPlayInfo> playInfo) {
        this.playInfo = playInfo;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public String getWaterMarks() {
        return waterMarks;
    }

    public void setWaterMarks(String waterMarks) {
        this.waterMarks = waterMarks;
    }

    public String getAdTrack() {
        return adTrack;
    }

    public void setAdTrack(String adTrack) {
        this.adTrack = adTrack;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShareAdTrack() {
        return shareAdTrack;
    }

    public void setShareAdTrack(String shareAdTrack) {
        this.shareAdTrack = shareAdTrack;
    }

    public String getWebAdTrack() {
        return webAdTrack;
    }

    public void setWebAdTrack(String webAdTrack) {
        this.webAdTrack = webAdTrack;
    }

    public String getFavoriteAdTrack() {
        return favoriteAdTrack;
    }

    public void setFavoriteAdTrack(String favoriteAdTrack) {
        this.favoriteAdTrack = favoriteAdTrack;
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }

    public boolean isPlayed() {
        return played;
    }

    public void setPlayed(boolean played) {
        this.played = played;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(long releaseTime) {
        this.releaseTime = releaseTime;
    }

    public DetailItemProvider getProvider() {
        return provider;
    }

    public void setProvider(DetailItemProvider provider) {
        this.provider = provider;
    }

    public DetailItemCover getCover() {
        return cover;
    }

    public void setCover(DetailItemCover cover) {
        this.cover = cover;
    }

    public List<DetailItemTag> getTags() {
        return tags;
    }

    public void setTags(List<DetailItemTag> tags) {
        this.tags = tags;
    }

    public DetailItemWebUrl getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(DetailItemWebUrl webUrl) {
        this.webUrl = webUrl;
    }

    public DetailItemConsumption getConsumption() {
        return consumption;
    }

    public void setConsumption(DetailItemConsumption consumption) {
        this.consumption = consumption;
    }

    @Override
    public String toString() {
        return "DetailItem{" +
                "dataType='" + dataType + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", author=" + author +
                ", playInfo=" + playInfo +
                ", playUrl='" + playUrl + '\'' +
                ", campaign='" + campaign + '\'' +
                ", waterMarks='" + waterMarks + '\'' +
                ", adTrack='" + adTrack + '\'' +
                ", type='" + type + '\'' +
                ", shareAdTrack='" + shareAdTrack + '\'' +
                ", webAdTrack='" + webAdTrack + '\'' +
                ", favoriteAdTrack='" + favoriteAdTrack + '\'' +
                ", collected=" + collected +
                ", played=" + played +
                ", id=" + id +
                ", duration=" + duration +
                ", idx=" + idx +
                ", date=" + date +
                ", releaseTime=" + releaseTime +
                ", provider=" + provider +
                ", cover=" + cover +
                ", tags=" + tags +
                ", webUrl=" + webUrl +
                ", consumption=" + consumption +
                '}';
    }
}
