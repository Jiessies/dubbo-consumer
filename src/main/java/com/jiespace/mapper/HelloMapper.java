package com.jiespace.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HelloMapper {
    String findOrder(String findOrder);
}
