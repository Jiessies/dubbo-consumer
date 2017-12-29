package com.jiespace.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jiespace.domain.City;
import org.springframework.stereotype.Component;

/**
 * Created by huangmingjie on 2017/10/12.
 */
@Component
public class CityDubboConsumerService {

    @Reference(group = "helloService", version = "1.0")
    CityDubboService helloService;
    
    @Reference(group = "cityService", version = "1.0.0")
    CityDubboService cityDubboService;
    
    public City printCity(String cityName) {
        return helloService.findCityByName(cityName);
    }
    
    public City printCityDubbo(String cityName) {
        return cityDubboService.findCityByName(cityName);
    }
}
