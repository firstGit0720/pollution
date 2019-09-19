package com.weather.pollution.pojo;

import java.util.Date;

public class Pollution {
    private int id;
    private String place;
    private Date polTime;
    private int aqi;
    private int aqiPm;
    private String aqg;
    private int pm2;
    private int pm10;
    private int so2;
    private double co1;
    private int no2;
    private int o3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getPolTime() {
        return polTime;
    }

    public void setPolTime(Date polTime) {
        this.polTime = polTime;
    }

    public int getAqi() {
        return aqi;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }

    public int getAqiPm() {
        return aqiPm;
    }

    public void setAqiPm(int aqiPm) {
        this.aqiPm = aqiPm;
    }

    public String getAqg() {
        return aqg;
    }

    public void setAqg(String aqg) {
        this.aqg = aqg;
    }

    public int getPm2() {
        return pm2;
    }

    public void setPm2(int pm2) {
        this.pm2 = pm2;
    }

    public int getPm10() {
        return pm10;
    }

    public void setPm10(int pm10) {
        this.pm10 = pm10;
    }

    public int getSo2() {
        return so2;
    }

    public void setSo2(int so2) {
        this.so2 = so2;
    }

    public double getCo1() {
        return co1;
    }

    public void setCo1(double co1) {
        this.co1 = co1;
    }

    public int getNo2() {
        return no2;
    }

    public void setNo2(int no2) {
        this.no2 = no2;
    }

    public int getO3() {
        return o3;
    }

    public void setO3(int o3) {
        this.o3 = o3;
    }
}
