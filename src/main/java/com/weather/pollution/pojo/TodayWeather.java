package com.weather.pollution.pojo;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.Date;

public class TodayWeather {
    private int id;
    private Date todaytime;  //时间
    private double nowtemp; //现在的温度
    private String nowstatus; //天气状态
    private String nowhumidity; //相对湿度
    private double nowaqinum;  //aqi指数
    private String nowaqi;  //污染等级
    private  String nowwind; //风向
    private String nowwindnum;//风级

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTodaytime() {
        return todaytime;
    }

    public void setTodaytime(Date todaytime) {
        this.todaytime = todaytime;
    }


    public double getNowtemp() {
        return nowtemp;
    }

    public void setNowtemp(double nowtemp) {
        this.nowtemp = nowtemp;
    }

    public String getNowstatus() {
        return nowstatus;
    }

    public void setNowstatus(String nowstatus) {
        this.nowstatus = nowstatus;
    }

    public String getNowhumidity() {
        return nowhumidity;
    }

    public void setNowhumidity(String nowhumidity) {
        this.nowhumidity = nowhumidity;
    }

    public double getNowaqinum() {
        return nowaqinum;
    }

    public void setNowaqinum(double nowaqinum) {
        this.nowaqinum = nowaqinum;
    }

    public String getNowaqi() {
        return nowaqi;
    }

    public void setNowaqi(String nowaqi) {
        this.nowaqi = nowaqi;
    }

    public String getNowwind() {
        return nowwind;
    }

    public void setNowwind(String nowwind) {
        this.nowwind = nowwind;
    }

    public String getNowwindnum() {
        return nowwindnum;
    }

    public void setNowwindnum(String nowwindnum) {
        this.nowwindnum = nowwindnum;
    }
}
