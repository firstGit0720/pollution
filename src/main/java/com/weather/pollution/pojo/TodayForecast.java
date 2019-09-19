package com.weather.pollution.pojo;


import java.util.Date;

public class TodayForecast {

    private int id;
    private String cityname;//城市
    private Date nowtime;  //时间
    private double nowtemp; //现在的温度
    private double nowyq;  //压强
    private String nowjy; //降雨量
    private String nowsd; //相对湿度
    private  String nowfx; //风向
    private String nowfs;//风速


    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }


    public double getNowyq() {
        return nowyq;
    }

    public void setNowyq(double nowyq) {
        this.nowyq = nowyq;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date  getNowtime() {
        return nowtime;
    }

    public void setNowtime(Date nowtime) {
        this.nowtime = nowtime;
    }

    public double getNowtemp() {
        return nowtemp;
    }

    public void setNowtemp(double nowtemp) {
        this.nowtemp = nowtemp;
    }

    public String getNowjy() {
        return nowjy;
    }

    public void setNowjy(String nowjy) {
        this.nowjy = nowjy;
    }

    public String getNowsd() {
        return nowsd;
    }

    public void setNowsd(String nowsd) {
        this.nowsd = nowsd;
    }

    public String getNowfx() {
        return nowfx;
    }

    public void setNowfx(String nowfx) {
        this.nowfx = nowfx;
    }

    public String getNowfs() {
        return nowfs;
    }

    public void setNowfs(String nowfs) {
        this.nowfs = nowfs;
    }
}
