package com.moc.controller;

import com.moc.entity.WeatherResponse;
import com.moc.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @description: TODO
 * @author: huangW
 * @createDate: 2020/2/8 21:36
 * @version: 1.0
 */
@Controller
public class WeatherController {

    @Value("${url.weather}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WeatherDataService weatherDataService;

    @RequestMapping(value = "/{city}", method = RequestMethod.GET)
    public String get(@PathVariable("city") String city, Model model) {
        if(city.equalsIgnoreCase("wh"))
            city = "武汉";
        String URL = url + city;
        ResponseEntity<String> entity = restTemplate.getForEntity(URL, String.class);
        WeatherResponse weather = weatherDataService.getWeather(entity.getBody());
        if (weather == null) return "error";

        model.addAttribute("Forecast", weather.getForecastList());
        model.addAttribute("weather", weather.getWeather());
        return "weather";
    }

}
