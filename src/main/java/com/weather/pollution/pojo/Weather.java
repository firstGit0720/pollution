package com.weather.pollution.pojo;

//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
import java.util.Date;

//@Getter
//@Setter
//@ToString
public class Weather {
    private int id;
    private String place;
    private Date weatherTime;
    private int maxTem;
    private int minTem;
    private String status;
    private String windDir;
    private String windScale;

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

    public Date getWeatherTime() {
        return weatherTime;
    }

    public void setWeatherTime(Date weatherTime) {
        this.weatherTime = weatherTime;
    }

    public int getMaxTem() {
        return maxTem;
    }

    public void setMaxTem(int maxTem) {
        this.maxTem = maxTem;
    }

    public int getMinTem() {
        return minTem;
    }

    public void setMinTem(int minTem) {
        this.minTem = minTem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public String getWindScale() {
        return windScale;
    }

    public void setWindScale(String windScale) {
        this.windScale = windScale;
    }


}
