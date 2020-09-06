package cn.muchen7.dao.bean;

import com.google.gson.Gson;

public class ConfigBean {
    public static ConfigBean getConfigBean(String value){
        return new Gson().fromJson(value, ConfigBean.class);
    }
    public String toJson(){
        return new Gson().toJson(this);
    }
    /**网站标题**/
    private String title;

    /**网站版权信息**/
    private String copyright;

    /**网站副标题**/
    protected String subtitle;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

}
