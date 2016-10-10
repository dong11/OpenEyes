package com.rex.hwong.openeyes.bean.discovery;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 16/10/10
 * @time 下午5:55
 */

/**
 *  {
 *      dataType: "SquareCard",
 *      id: 30,
 *      title: "#游戏",
 *      image: "http://img.kaiyanapp.com/2b7ac9d21ca06df7e39e80a3799a3fb6.jpeg",
 *      actionUrl: "eyepetizer://category/30/?title=%E6%B8%B8%E6%88%8F",
 *      shade: true,
 *      adTrack: null
 *  }
 */
public class DiscoveryItem {
    private int id;
    private String title;
    private String dataType;
    private String image;
    private String actionUrl;
    private boolean shade;
    private String adTrack;

    public DiscoveryItem() {
    }

    public DiscoveryItem(int id, String title, String dataType, String image, String actionUrl, boolean shade, String adTrack) {
        this.id = id;
        this.title = title;
        this.dataType = dataType;
        this.image = image;
        this.actionUrl = actionUrl;
        this.shade = shade;
        this.adTrack = adTrack;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    public boolean isShade() {
        return shade;
    }

    public void setShade(boolean shade) {
        this.shade = shade;
    }

    public String getAdTrack() {
        return adTrack;
    }

    public void setAdTrack(String adTrack) {
        this.adTrack = adTrack;
    }

    @Override
    public String toString() {
        return "DiscoveryItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dataType='" + dataType + '\'' +
                ", image='" + image + '\'' +
                ", actionUrl='" + actionUrl + '\'' +
                ", shade=" + shade +
                ", adTrack='" + adTrack + '\'' +
                '}';
    }
}
