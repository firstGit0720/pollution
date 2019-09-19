package com.weather.pollution.dao.impl;

import com.weather.pollution.dao.PollutionService;
import com.weather.pollution.mapper.PollutionMapper;
import com.weather.pollution.pojo.Pollution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PollutionServiceImpl implements PollutionService {
    @Autowired
    private PollutionMapper pollutionMapper;

    @Override
    public List<Pollution> showPollutionSer(String cityname) {
        return pollutionMapper.showPollution(cityname);
    }

    @Override
    public int numPolDaysSer() {
        return pollutionMapper.numPolDays();
    }

    @Override
    public int selectPolDays(String aqg) {
        return pollutionMapper.selectPolDays(aqg);
    }

    @Override
    public List<Pollution> selectPollutionByTime(String polTime) {
        return pollutionMapper.selectPollutionByTime(polTime);
    }

    @Override
    public List<Pollution> selectAllByPolTime(String cityname,Date startTime, Date endTime) {
        return pollutionMapper.selectAllByPolTime(cityname,startTime, endTime);
    }

    @Override
    public String lastPollution() {
        return pollutionMapper.lastPollution();
    }

    @Override
    public double PM25Avge(String dateTime) {
        return pollutionMapper.PM25Avge(dateTime);
    }

    @Override
    public double PM10Avge(String dateTime) {
        return pollutionMapper.PM10Avge(dateTime);
    }

    @Override
    public double SO2Avge(String dateTime) {
        return pollutionMapper.SO2Avge(dateTime);
    }

    @Override
    public double NO2Avge(String dateTime) {
        return pollutionMapper.NO2Avge(dateTime);
    }

    @Override
    public double CO1Avge(String dateTime) {
        return pollutionMapper.CO1Avge(dateTime);
    }

    @Override
    public double O3Avge(String dateTime) {
        return pollutionMapper.O3Avge(dateTime);
    }

}
