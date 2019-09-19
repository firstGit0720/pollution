package com.weather.pollution.dao.impl;

import com.weather.pollution.dao.FutureWeatherService;
import com.weather.pollution.mapper.FutureWeatherMapper;
import com.weather.pollution.pojo.FutureWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FutureWeatherServiceImpl implements FutureWeatherService {

    @Autowired
    private FutureWeatherMapper futureWeatherMapper;

    @Override
    public List<FutureWeather> showFutureWeatherdays(String city) {
        return futureWeatherMapper.showFutureWeatherdays(city);
    }

    @Override
    public List<FutureWeather> showFutureWeather(String city) {
        return futureWeatherMapper.showFutureWeather(city);
    }
}
