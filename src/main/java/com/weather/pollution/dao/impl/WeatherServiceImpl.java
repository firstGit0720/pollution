package com.weather.pollution.dao.impl;

import com.weather.pollution.dao.WeatherService;
import com.weather.pollution.mapper.WeatherMapper;
import com.weather.pollution.pojo.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    private WeatherMapper weatherMapper;
    @Override
    public List<Weather> showWeather(String cityname) {
        return weatherMapper.showWeather(cityname);
    }

    @Override
    public List<Weather> selectWeatherByTime(Date startTime, Date endTime,String cityname) {
        return weatherMapper.selectAllByWeatherTime(startTime,endTime,cityname);
    }
}
