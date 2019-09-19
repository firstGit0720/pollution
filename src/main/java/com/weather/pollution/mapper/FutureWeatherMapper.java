package com.weather.pollution.mapper;

import com.weather.pollution.pojo.FutureWeather;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FutureWeatherMapper {

    //显示未来七天的信息
    @Select("select * from future where place=#{city} order by id DESC LIMIT 23,7")
    public List<FutureWeather> showFutureWeatherdays(@Param("city") String city);

    //显示呢未来30天的信息
    @Select("select * from future where place=#{city} order by id DESC LIMIT 0,30")
    public List<FutureWeather> showFutureWeather(@Param("city") String city);
}
