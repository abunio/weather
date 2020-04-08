package com.moc.service.impl;

import com.alibaba.fastjson.JSON;

import com.moc.entity.Forecast;
import com.moc.entity.Weather;
import com.moc.entity.WeatherResponse;
import com.moc.service.WeatherDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @description: TODO
 * @author: huangW
 * @createDate: 2020/2/9 22:15
 * @version: 1.0
 */
@Service
@Slf4j
public class WeatherDataServiceImpl implements WeatherDataService {


    /**
     * 数据处理
     *
     * @param body
     * @return
     */
    @Override
    public WeatherResponse getWeather(String body) {

        WeatherResponse weatherResponse = new WeatherResponse();
        log.info("body-->" + body);
        Map<String,Object> map = JSON.parseObject(body);
        if(String.valueOf(map.get("status")).equals("1000")){
            Map<String,Object> maps = JSON.parseObject(String.valueOf(map.get("data")));

            Weather weather = new Weather();
            weather.setCity(String.valueOf(maps.get("city")));
            weather.setGanmao(String.valueOf(maps.get("ganmao")));
            weather.setWendu(String.valueOf(maps.get("wendu")));
            String s = "当前城市：" + weather.getCity() + "，当前温度：" + weather.getWendu() + " 度。";
            weather.setCitys(s);
            weatherResponse.setWeather(weather);

            List<Forecast> list = JSON.parseArray(String.valueOf(maps.get("forecast")), Forecast.class);
            weatherResponse.setForecastList(list);
            return weatherResponse;
        }
        return null;
    }
}
