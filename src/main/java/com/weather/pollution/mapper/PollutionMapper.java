package com.weather.pollution.mapper;


import com.sun.tracing.dtrace.ProviderAttributes;
import com.weather.pollution.pojo.Pollution;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.tomcat.jni.Poll;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * Create with IDEA
 * Author:Yangxiaoyan
 * Date:2018/8/3
 * Time:17:26
 **/
@Mapper
public interface PollutionMapper {
     /**
      * 显示污染数据总天数
      * @return
      */
     @Select("select count(*) from pollution")
     int numPolDays();

     /**
      * 根据污染级别查找总共的天数
      * @return
      */
     @Select("select count(*) from pollution where aqg = #{aqg}")
     int selectPolDays(@Param("aqg") String aqg);

     /**
      * 根据图表显示相应的污染物的变化
      * @return
      */
     @Select("select * from pollution WHERE place=#{place} order by id DESC LIMIT 0,100")
     List<Pollution> showPollution(@Param("place") String place);
    //按时间模糊查询
    @Select("select * from pollution where polTime like '%${polTime}%'")
     List<Pollution> selectPollutionByTime(@Param("polTime") String polTime);
    //按时间段查询
    @Select("select * from pollution where place=#{cityname} and polTime >= #{startTime} and polTime <= #{endTime}")
    List<Pollution> selectAllByPolTime(@Param("cityname")String cityname,@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    //查询最后一条信息的时间用于计算平均值
    @Select("select pollution.polTime from pollution order by id DESC LIMIT 0,1")
    String lastPollution();

    //计算平均值
    //PM2.5平均值
    @Select("select AVG(pm2) from pollution where polTime like '%${dateTime}%'")
    double PM25Avge(@Param("dateTime") String dateTime);
    //PM10平均值
    @Select("select AVG(pm10) from pollution where polTime like '%${dateTime}%'")
    double PM10Avge(@Param("dateTime")String dateTime);
    //SO2平均值
    @Select("select AVG(so2) from pollution where polTime like '%${dateTime}%'")
    double SO2Avge(@Param("dateTime")String dateTime);
    //No2平均值
    @Select("select AVG(no2) from pollution where polTime like '%${dateTime}%'")
    double NO2Avge(@Param("dateTime")String dateTime);
    //Co1平均值
    @Select("select AVG(co1) from pollution where polTime like '%${dateTime}%'")
    double CO1Avge(@Param("dateTime")String dateTime);
    //O3平均值
    @Select("select AVG(o3) from pollution where polTime like '%${dateTime}%'")
    double O3Avge(@Param("dateTime")String dateTime);

}
