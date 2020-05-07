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

    @Autowired
    private WeatherDataService weatherDataService;

    @RequestMapping("")
    public String index(Model model){
        WeatherResponse weather = weatherDataService.getWeather("武汉");
        if (weather == null) return "error";

        model.addAttribute("Forecast", weather.getForecastList());
        model.addAttribute("weather", weather.getWeather());
        return "index";
    }

    @RequestMapping("/index")
    public String indexs(Model model){
        WeatherResponse weather = weatherDataService.getWeather("武汉");
        if (weather == null) return "error";

        model.addAttribute("Forecast", weather.getForecastList());
        model.addAttribute("weather", weather.getWeather());
        return "index";
    }

    @RequestMapping(value = "/{city}", method = RequestMethod.GET)
    public String get(@PathVariable("city") String city, Model model) {

        WeatherResponse weather = weatherDataService.getWeather(city);
        if (weather == null) return "error";

        model.addAttribute("Forecast", weather.getForecastList());
        model.addAttribute("weather", weather.getWeather());
        return "index";
    }

    @RequestMapping(value = "/weather", method = RequestMethod.GET)
    public String gets(@RequestParam("city") String city, Model model) {
        WeatherResponse weather = weatherDataService.getWeather(city);
        if (weather == null) return "error";

        model.addAttribute("Forecast", weather.getForecastList());
        model.addAttribute("weather", weather.getWeather());
        return "index";
    }

}
