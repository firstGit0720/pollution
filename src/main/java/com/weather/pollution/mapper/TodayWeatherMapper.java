package com.weather.pollution.mapper;

import com.weather.pollution.pojo.TodayWeather;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface TodayWeatherMapper {
    @Select("select  * from nowweather where cityname=#{cityname} order by id DESC LIMIT 0,1")
    public TodayWeather showTodayWeather(@Param("cityname") String cityname);
}
