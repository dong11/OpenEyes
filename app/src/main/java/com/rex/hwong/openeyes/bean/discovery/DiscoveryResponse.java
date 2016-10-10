package com.rex.hwong.openeyes.bean.discovery;

import java.util.List;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 16/10/10
 * @time 下午5:49
 */

public class DiscoveryResponse {
    private List<DiscoveryData> itemList;
    private int count;
    private int total;
    private String nextPageUrl;

    public DiscoveryResponse() {
    }

    public DiscoveryResponse(List<DiscoveryData> itemList, int count, int total, String nextPageUrl) {
        this.itemList = itemList;
        this.count = count;
        this.total = total;
        this.nextPageUrl = nextPageUrl;
    }

    public List<DiscoveryData> getItemList() {
        return itemList;
    }

    public void setItemList(List<DiscoveryData> itemList) {
        this.itemList = itemList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    @Override
    public String toString() {
        return "DiscoveryResponse{" +
                "itemList=" + itemList +
                ", count=" + count +
                ", total=" + total +
                ", nextPageUrl='" + nextPageUrl + '\'' +
                '}';
    }
}
