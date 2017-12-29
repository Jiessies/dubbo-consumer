package com.jiespace.dubbo;


import com.jiespace.domain.City;

/**
 * Created by huangmingjie on 2017/10/12.
 */
public interface CityDubboService {
    
    City findCityByName(String cityName);
}
