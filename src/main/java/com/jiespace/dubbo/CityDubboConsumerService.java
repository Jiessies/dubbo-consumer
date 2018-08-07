package com.jiespace.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.codingapi.tx.annotation.TxTransaction;
import com.jiespace.domain.City;
import com.jiespace.domain.TestOrder;
import com.jiespace.domain.TripShop;
import com.jiespace.mapper.CityDubboMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by huangmingjie on 2017/10/12.
 */
@Component
public class CityDubboConsumerService {

    @Reference(group = "helloService", version = "1.0.2")
    CityDubboService helloService;
    
    @Reference(group = "cityService", version = "1.0.1")
    CityDubboService cityDubboService;

    @Autowired
    private CityDubboMapper cityDubboMapper;

    public City printCity(String cityName) {
        return helloService.findCityByName(cityName);
    }

    @TxTransaction(isStart = true)
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public City printCityDubbo(String cityName) {
        City city = cityDubboService.findCityByName(cityName);

        TripShop tripShop = new TripShop();
        tripShop.setDay_id(1);
        tripShop.setShop_explian("Shop_explian");
        tripShop.setShop_name("beijingfendian");
        tripShop.setShop_product("chanpinmingcheng");
        tripShop.setStay_time("15hour");
        cityDubboMapper.insertTripShop(tripShop);
        int a = 100/0;
        TestOrder order = new TestOrder();
        order.setOrderNo(String.valueOf(System.currentTimeMillis()) + cityName + "consumer");
        order.setCreatetime(new Date());
        order.setOrderstatus(1);
        order.setOrderprice(100);
        cityDubboMapper.insertOrder(order);
        return city;
    }
}
