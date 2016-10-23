package com.rex.hwong.openeyes.bean.discovery.detail;

import java.io.Serializable;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 2016/10/22
 * @time 下午10:36
 */

public class DetailItemConsumption implements Serializable {
    private int collectionCount;
    private int shareCount;
    private int replyCount;

    public DetailItemConsumption() {
    }

    public DetailItemConsumption(int collectionCount, int shareCount, int replyCount) {
        this.collectionCount = collectionCount;
        this.shareCount = shareCount;
        this.replyCount = replyCount;
    }

    public int getCollectionCount() {
        return collectionCount;
    }

    public void setCollectionCount(int collectionCount) {
        this.collectionCount = collectionCount;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    @Override
    public String toString() {
        return "DetailItemConsumption{" +
                "collectionCount=" + collectionCount +
                ", shareCount=" + shareCount +
                ", replyCount=" + replyCount +
                '}';
    }
}
