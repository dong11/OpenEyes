package com.rex.hwong.openeyes.bean.discovery.detail;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 2016/10/22
 * @time 下午10:22
 */

public class DetailResponse {
    private String nextPageUrl;
    private int count;
    private int total;
    private ArrayList<DetailData> itemList;

    public DetailResponse() {
    }

    public DetailResponse(String nextPageUrl, int count, int total, ArrayList<DetailData> itemList) {
        this.nextPageUrl = nextPageUrl;
        this.count = count;
        this.total = total;
        this.itemList = itemList;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
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

    public ArrayList<DetailData> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<DetailData> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "DetailResponse{" +
                "nextPageUrl='" + nextPageUrl + '\'' +
                ", count=" + count +
                ", total=" + total +
                ", itemList=" + itemList +
                '}';
    }
}
