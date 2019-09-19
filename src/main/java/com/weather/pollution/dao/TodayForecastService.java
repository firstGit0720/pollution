package com.weather.pollution.dao;

import com.weather.pollution.pojo.TodayForecast;

import java.util.Date;
import java.util.List;

public interface TodayForecastService {
    //查看所有预测的信息
    public List<TodayForecast> showTodayForecast(String datetime,String cityname);
    //查看预测的压强默认显示100条
    public List<TodayForecast> showPressure(String cityname);
    //按时间段查询
    public List<TodayForecast> selectPressureByTime(String cityname,Date startTime,Date endTime);
}
