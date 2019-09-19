package com.weather.pollution.mapper;


import com.weather.pollution.pojo.Weather;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.Date;
import java.util.List;

//已经在启动类中添加了@MapperScan
@Mapper
public interface WeatherMapper {

    @Select("Select  * from weather WHERE place=#{place} order by id DESC LIMIT 0,100")
    public List<Weather> showWeather(@Param("place") String place);
    //时间段查询
    @Select("select * from weather where weatherTime >= #{startTime} and weatherTime <=#{endTime} and place = #{place}")
    List<Weather> selectAllByWeatherTime(@Param("startTime") Date startTime, @Param("endTime") Date endTime,@Param("place") String place);

}
