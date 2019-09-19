package com.weather.pollution.controller;

import com.weather.pollution.dao.impl.PollutionServiceImpl;
import com.weather.pollution.pojo.Pollution;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.security.util.Length;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Create with IDEA
 * Author:Yangxiaoyan
 * Date:2018/8/4
 * Time:10:29
 **/
@RestController
public class PollutionController {


    @Autowired
    private PollutionServiceImpl pollutionService;



    @GetMapping(value = "/polDaysNum")
    public int polDaysNum(){

        return pollutionService.numPolDaysSer();
    }

    @GetMapping(value = "/pollutionShow")
    public  List<Pollution> pollutionShow(String place){
        if (place == null){
            place = "廊坊市";
        }
        String city =place.substring(0,2);
        return pollutionService.showPollutionSer(city);

    }

    //前端aqi饼状图显示
    @GetMapping(value = "/polDaysSelect")
    public Map<String,Integer> polDaysSelect(){
        int you = pollutionService.selectPolDays("优");
        int liang = pollutionService.selectPolDays("良");
        int qd = pollutionService.selectPolDays("轻度污染");
        int zhong = pollutionService.selectPolDays("中度污染");
        int zd = pollutionService.selectPolDays("重度污染");
//        System.out.print(you+","+liang+","+qd+","+zhong+","+zd);
        Map<String,Integer> map = new HashMap<>();
        map.put("you",you);
        map.put("liang",liang);
        map.put("qd",qd);
        map.put("zhong",zhong);
        map.put("zd",zd);
        return map;
    }

    //总览
   //计算平均值
   @GetMapping("/polMonAvgeShow")
   public Map<String,Object> avgeShow()throws ParseException {

       int yearsum = pollutionService.numPolDaysSer();
       int year = yearsum / 365 + 2;
       String [][] years = new String[year][12];
       double[][] pm25 = new double[year][12];
       double[][] pm10 = new double[year][12];
       double[][] so2 = new double[year][12];
       double[][] no2 = new double[year][12];
       double[][] co1 = new double[year][12];
       double[][] o3 = new double[year][12];

       List<String> yearlist = new ArrayList<>();
       for (int i = 0; i < year; i++) {
           String stryear = "201" + (3+i);
           yearlist.add(stryear);
       }
       //13年只有两个月单独拿出来
       years[0][0] = "2013-11";
       years[0][1] = "2013-12";

       for (int i = 0;i< 2 ; i++ ){
           pm25[0][i] = pollutionService.PM25Avge(years[0][i]);
           pm10[0][i] =pollutionService.PM10Avge(years[0][i]);
           no2[0][i] =pollutionService.NO2Avge(years[0][i]);
           so2[0][i] =pollutionService.SO2Avge(years[0][i]);
           co1[0][i] =pollutionService.CO1Avge(years[0][i]);
           o3[0][i] =pollutionService.O3Avge(years[0][i]);
       }
       //中间部分
       for (int i = 1; i < year-1; i++) {
           for (int j = 0; j < 12; j++) {
               if (j < 9) {
                   String strmon ="0"+ String.valueOf(j+1);
                   String time = yearlist.get(i) + "-" + strmon;
                   years[i][j] = time;
                   pm25[i][j] = pollutionService.PM25Avge(time);
                   pm10[i][j] =pollutionService.PM10Avge(time);
                   no2[i][j] =pollutionService.NO2Avge(time);
                   so2[i][j] =pollutionService.SO2Avge(time);
                   co1[i][j] =pollutionService.CO1Avge(time);
                   o3[i][j] =pollutionService.O3Avge(time);
               }else{
                   String strmon =String.valueOf(j+1);
                   String time = yearlist.get(i) + "-" + strmon;
                   years[i][j] = time;
                   pm25[i][j] = pollutionService.PM25Avge(time);
                   pm10[i][j] =pollutionService.PM10Avge(time);
                   no2[i][j] =pollutionService.NO2Avge(time);
                   so2[i][j] =pollutionService.SO2Avge(time);
                   co1[i][j] =pollutionService.CO1Avge(time);
                   o3[i][j] =pollutionService.O3Avge(time);
               }

           }
       }
       //最后的部分，也就是今年的
       String strnowtime = pollutionService.lastPollution();
       int length = Integer.parseInt(strnowtime.substring(5,7));
       System.out.print(length);
       for (int j = 0 ;j<length;j++){
           if (j < 9) {
               String strmon ="0"+ String.valueOf(j+1);
               String time = yearlist.get(year-1) + "-" + strmon;
               years[year-1][j] = time;
               pm25[year-1][j] = pollutionService.PM25Avge(time);
               pm10[year-1][j] =pollutionService.PM10Avge(time);
               no2[year-1][j] =pollutionService.NO2Avge(time);
               so2[year-1][j] =pollutionService.SO2Avge(time);
               co1[year-1][j] =pollutionService.CO1Avge(time);
               o3[year-1][j] =pollutionService.O3Avge(time);
           }else{
               String strmon =String.valueOf(j+1);
               String time = yearlist.get(year-1) + "-" + strmon;
               years[year-1][j] = time;
               pm25[year-1][j] = pollutionService.PM25Avge(time);
               pm10[year-1][j] =pollutionService.PM10Avge(time);
               no2[year-1][j] =pollutionService.NO2Avge(time);
               so2[year-1][j] =pollutionService.SO2Avge(time);
               co1[year-1][j] =pollutionService.CO1Avge(time);
               o3[year-1][j] =pollutionService.O3Avge(time);
           }
       }
       String [] timeArray = new String[2+(year-2)*12+length];
       double [] pm25Array = new double[2+(year-2)*12+length];
       double [] pm10Array = new double[2+(year-2)*12+length];
       double [] no2Array = new double[2+(year-2)*12+length];
       double [] coArray = new double[2+(year-2)*12+length];
       double [] so2Array = new double[2+(year-2)*12+length];
       double [] o3Array = new double[2+(year-2)*12+length];
        //2013年
        timeArray[0] = years[0][0];
        pm25Array[0] = pm25[0][0];
        pm10Array[0] = pm10[0][0];
        no2Array[0] = no2[0][0];
        so2Array[0] = so2[0][0];
        coArray[0] = co1[0][0];
        o3Array[0] = o3[0][0];
        timeArray[1] = years[0][1];
       pm25Array[1] = pm25[0][1];
       pm10Array[1] = pm10[0][1];
       no2Array[1] = no2[0][1];
       so2Array[1] = so2[0][1];
       coArray[1] = co1[0][1];
       o3Array[1] = o3[0][1];
        int a = 2;
        //中间的年份
       for (int i = 1;i<year-1;i++){
           for(int j=0;j<12;j++,a++ ){
               timeArray[a] = years[i][j];
               pm25Array[a] = pm25[i][j];
               pm10Array[a] = pm10[i][j];
               no2Array[a] = no2[i][j];
               so2Array[a] = so2[i][j];
               coArray[a] = co1[i][j];
               o3Array[a] = o3[i][j];
           }
       }
       //今年的
       for (int j = 0 ;j<length;j++,a++){
           timeArray[a] = years[year-1][j];
           pm25Array[a] = pm25[year-1][j];
           pm10Array[a] = pm10[year-1][j];
           no2Array[a] = no2[year-1][j];
           so2Array[a] = so2[year-1][j];
           coArray[a] = co1[year-1][j];
           o3Array[a] = o3[year-1][j];
       }


       Map<String,Object> map = new HashMap<>();
       map.put("timeArray",timeArray);
       map.put("pm25Array",pm25Array);
       map.put("pm10Array",pm10Array);
       map.put("no2Array",no2Array);
       map.put("so2Array",so2Array);
       map.put("co1Array",coArray);
       map.put("o3Array",o3Array);

       return map;
   }



   //按时间段查找
   @GetMapping(value = "/selectAllByPolTime")
   public List<Pollution> selectAllByPolTime(String cityname,String startTime,String endTime)throws ParseException{
        String city = cityname.substring(0,2);

       DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
       Date startTimeFormat = format2.parse(startTime);  //字符串向Date转换
       Date endTimeFormat = format2.parse(endTime);
//        System.out.print(city);
//       System.out.println(startTimeFormat);
//       System.out.println(endTimeFormat);

       return pollutionService.selectAllByPolTime(city,startTimeFormat,endTimeFormat);
   }

}
