package com.weather.pollution.controller;

import com.weather.pollution.dao.impl.WeatherServiceImpl;
import com.weather.pollution.pojo.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
public class WeatherController {

    @Autowired
    private WeatherServiceImpl weatherService;

    @GetMapping("/showWeather")
    public List<Weather> showWeather(String cityname){
        if(cityname == null){
            cityname = "廊坊市";
        }
        String city = cityname.substring(0,2);
        System.out.print(city);
        List<Weather> weatherList = weatherService.showWeather(city);
        return weatherList;
    }



    @GetMapping(value = "/selectWeatherByTime")
    public List<Weather> selectWeatherByTime(String startTime,String endTime,String cityname) throws ParseException {
        DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        Date startTimeFormat = format2.parse(startTime);  //字符串向Date转换
        Date endTimeFormat = format2.parse(endTime);
//        if(cityname == null){
//            cityname = "廊坊市";
//        }
        String city = cityname.substring(0,2);
        return  weatherService.selectWeatherByTime(startTimeFormat,endTimeFormat,city);
    }

}
