package com.crc.bijiao;

/**
 * @Author: kunrong
 * @Date: 2019/8/21 11:44
 * @Description:
 **/
public class Fuwu {
    private  String servId;
    private  String appsysId;
    private String registerTime;

    public Fuwu(String servId, String appsysId, String registerTime) {
        this.servId = servId;
        this.appsysId = appsysId;
        this.registerTime = registerTime;
    }

    public String getServId() {
        return servId;
    }

    public void setServId(String servId) {
        this.servId = servId;
    }

    public String getAppsysId() {
        return appsysId;
    }

    public void setAppsysId(String appsysId) {
        this.appsysId = appsysId;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public String toString() {
        return "Fuwu{" +
                "servId='" + servId + '\'' +
                ", appsysId='" + appsysId + '\'' +
                ", registerTime='" + registerTime + '\'' +
                '}';
    }
}
