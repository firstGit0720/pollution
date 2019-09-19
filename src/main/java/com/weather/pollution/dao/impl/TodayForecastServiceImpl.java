package com.weather.pollution.dao.impl;

import com.weather.pollution.dao.TodayForecastService;
import com.weather.pollution.mapper.TodayForecastMapper;
import com.weather.pollution.pojo.TodayForecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TodayForecastServiceImpl implements TodayForecastService
{

    @Autowired
    private TodayForecastMapper todayForecastMapper;

    @Override
    public List<TodayForecast> showTodayForecast(String datetime,String cityname) {
        return todayForecastMapper.showTodayForecast(datetime,cityname);
    }

    @Override
    public List<TodayForecast> showPressure(String cityname) {
        return todayForecastMapper.showPressure(cityname);
    }

    @Override
    public List<TodayForecast> selectPressureByTime(String cityname, Date startTime, Date endTime) {
        return todayForecastMapper.selectPressureByTime(cityname, startTime, endTime);
    }
}
