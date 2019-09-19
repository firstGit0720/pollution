package com.weather.pollution.pojo;

import java.util.Date;

/**
 * 压强显示类
 *
 */
public class ShowPressure {
    private int id;
    private String cityName;  //城市
    private String  dateTime;   //时间
    private double pressure;   //压强
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }



}
