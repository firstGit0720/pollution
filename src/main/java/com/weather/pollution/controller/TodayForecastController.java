package com.weather.pollution.controller;

import com.weather.pollution.dao.impl.TodayForecastServiceImpl;
import com.weather.pollution.pojo.ShowPressure;
import com.weather.pollution.pojo.TodayForecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class TodayForecastController {

    @Autowired
    private TodayForecastServiceImpl todayForecastService;

    @GetMapping("/showtodayforecast")
    public List<TodayForecast> showTodayForecast(String cityname) throws ParseException {
        String city = cityname.substring(0,2);
        Date date = new Date();
        //date日期的格式化
        DateFormat bf = new SimpleDateFormat("yyyy-MM-dd");//多态
        String strtime = bf.format(date);//转化为字符串
        List<TodayForecast> todayForecast = todayForecastService.showTodayForecast(strtime,city);
        return todayForecast;
    }

    //查看压强
    @GetMapping("/showPressure")
    public List<ShowPressure> showPressure(String cityname, String startTime, String endTime ) throws ParseException {
        String city = cityname.substring(0,2);
        DateFormat bf = new SimpleDateFormat("yyyy-MM-dd");//多态
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        创建一盒显示压强的列表
        List<ShowPressure> pressures = new ArrayList<>();
        //如果时间不为空，按时间查询
        if(startTime != null & endTime != null){
            List<TodayForecast> lists = todayForecastService.selectPressureByTime(cityname, bf.parse(startTime), bf.parse(endTime));
            //创建压强预测的类对象
            TodayForecast todayForecast = new TodayForecast();

            for (int i = 0;i<lists.size();i++){
                todayForecast = lists.get(i);
                //创建显示压强对象
                ShowPressure showPressure = new ShowPressure();
                showPressure.setId(todayForecast.getId());
                showPressure.setCityName(todayForecast.getCityname());
                showPressure.setDateTime(formatter.format(todayForecast.getNowtime()));
                showPressure.setPressure(todayForecast.getNowyq());
                pressures.add(showPressure);
            }

        }
        //否则调用默认显示最近100条的查询
        else{
            //获得所有符合条件的信息
            List<TodayForecast> lists = todayForecastService.showPressure(city);
            //创建压强预测的类对象
            TodayForecast todayForecast = new TodayForecast();

            for (int i = 0;i<lists.size();i++){
                todayForecast = lists.get(i);
                //创建显示压强对象
                ShowPressure showPressure = new ShowPressure();
                showPressure.setId(todayForecast.getId());
                showPressure.setCityName(todayForecast.getCityname());
                showPressure.setDateTime(formatter.format(todayForecast.getNowtime()));
                showPressure.setPressure(todayForecast.getNowyq());
                pressures.add(showPressure);
            }

        }
        return pressures;
    }

}
