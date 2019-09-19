package com.weather.pollution.dao.impl;

import com.weather.pollution.dao.TodayWeatherService;
import com.weather.pollution.mapper.TodayWeatherMapper;
import com.weather.pollution.pojo.TodayWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodayWeatherServiceImpl implements TodayWeatherService {

    @Autowired
    private TodayWeatherMapper todayWeatherMapper;

    @Override
    public TodayWeather showTodayWeather(String cityname) {
        return todayWeatherMapper.showTodayWeather(cityname);
    }
}
