package com.jiespace.mapper;

import com.jiespace.domain.TestOrder;
import com.jiespace.domain.TripShop;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CityDubboMapper {
    int insertOrder(TestOrder order);
    int insertTripShop(TripShop tripShop);
}
