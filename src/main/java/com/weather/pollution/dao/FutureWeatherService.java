package com.weather.pollution.dao;

import com.weather.pollution.pojo.FutureWeather;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FutureWeatherService {

    //显示未来七天的信息
    public List<FutureWeather> showFutureWeatherdays(String city);

    //显示呢未来30天的信息
    public List<FutureWeather> showFutureWeather(String city);
}
