package com.jiespace.controller;

import com.jiespace.dubbo.CityDubboConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * Created by huangmingjie on 2017/10/12.
 */
@RestController
public class HelloController {
    
    @Autowired
    private CityDubboConsumerService cityDubboConsumerService;
    
    @GetMapping("/hello")
    public String getHello(@PathParam("cityName") String cityName){
        return cityDubboConsumerService.printCity(cityName).toString();
    }
    
    @GetMapping("/city")
    public String getCity(@PathParam("cityName") String cityName){
        return cityDubboConsumerService.printCityDubbo(cityName).toString();
    }
}

