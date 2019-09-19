package com.weather.pollution.dao;

import com.weather.pollution.pojo.Weather;

import java.util.Date;
import java.util.List;

public interface WeatherService {

    public List<Weather> showWeather(String cityname);

    //时间段查询
    public List<Weather> selectWeatherByTime(Date startTime, Date endTime,String cityname);

}
