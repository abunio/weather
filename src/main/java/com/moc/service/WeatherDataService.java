package com.moc.service;

import com.moc.entity.WeatherResponse;

public interface WeatherDataService {


    /**
     * 数据处理
     * @param body
     * @return
     */
    WeatherResponse getWeather(String body);
}
