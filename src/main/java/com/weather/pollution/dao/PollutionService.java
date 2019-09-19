package com.weather.pollution.dao;

import com.weather.pollution.pojo.Pollution;


import java.util.Date;
import java.util.List;

/**
 * Create with IDEA
 * Author:Yangxiaoyan
 * Date:2018/8/4
 * Time:22:26
 **/
public interface PollutionService {
    List<Pollution> showPollutionSer(String cityname);
    int numPolDaysSer();
    int selectPolDays(String aqg);

    //按时间的迷糊查询
    List<Pollution> selectPollutionByTime(String polTime);
    //按时间段查询
    List<Pollution> selectAllByPolTime(String cityname,Date startTime, Date endTime);


    //查询最后一条信息的时间用于计算平均值
    String lastPollution();
    //平均值计算
    public double PM25Avge(String dateTime);
    public double PM10Avge(String dateTime);
    public double NO2Avge(String dateTime);
    public double SO2Avge(String dateTime);
    public double CO1Avge(String dateTime);
    public double O3Avge(String dateTime);

}
