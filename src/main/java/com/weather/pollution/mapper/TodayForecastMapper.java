package com.weather.pollution.mapper;

import com.weather.pollution.pojo.TodayForecast;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface TodayForecastMapper {

    @Select("select * from forecastdays where nowtime like '%${datetime}%' and cityname = #{cityname}")
    public List<TodayForecast> showTodayForecast(@Param("datetime") String datetime,@Param("cityname") String cityname);

    //查看压强和时间（在没有选择时间短的情况下，默认显示最近的100条）
    @Select("select * from forecastdays where cityname = #{cityname} order by id DESC LIMIT 0,100")
    public List<TodayForecast> showPressure(@Param("cityname") String cityname);
    //根据时间段查询
    @Select("select * from forecastdays where cityname = #{cityname} and nowtime >=concat(#{startTime}, '%') and nowtime <=concat(#{endTime}, '%')")
    public List<TodayForecast> selectPressureByTime(@Param("cityname") String cityname,@Param("startTime") Date startTime, @Param("endTime") Date endTime);

}
