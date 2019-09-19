package com.weather.pollution.controller;

import com.weather.pollution.dao.impl.FutureWeatherServiceImpl;
import com.weather.pollution.dao.impl.TodayForecastServiceImpl;
import com.weather.pollution.dao.impl.TodayWeatherServiceImpl;
import com.weather.pollution.pojo.FutureWeather;
import com.weather.pollution.pojo.TodayForecast;
import com.weather.pollution.pojo.TodayWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class TodayWeatherController {

    @Autowired
    private TodayWeatherServiceImpl todayWeatherService;
    @Autowired
    private TodayForecastServiceImpl todayForecastService;
    @Autowired
    private FutureWeatherServiceImpl futureWeatherService;

    @GetMapping("/showtodayweather")
    public Map<String,Object> showTodayWeather(@RequestParam("cityname") String cityname){
        Map<String,Object> map = new HashMap<>();
        //截取字符串
        String city = cityname.substring(0,2);
//        System.out.print(city);
        //实时天气
        TodayWeather todayWeather = new TodayWeather();
        todayWeather = todayWeatherService.showTodayWeather(city);
        //预测天气
        Date date = new Date();
        //date日期的格式化
        DateFormat bf = new SimpleDateFormat("yyyy-MM-dd");//多态
        String strtime = bf.format(date);//转化为字符串
        //今天气温预测
        List<TodayForecast> todayForecast = todayForecastService.showTodayForecast(strtime,city);
        //未来七天
        List<FutureWeather> daysList = futureWeatherService.showFutureWeatherdays(city);
        //未来30天
        List<FutureWeather> monList = futureWeatherService.showFutureWeather(city);
        map.put("todayWeather",todayWeather);
        map.put("todayForrcast",todayForecast);
        map.put("daysForecast",daysList);
        map.put("monForecast",monList);
        return map;
    }

}
