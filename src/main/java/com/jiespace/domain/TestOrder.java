package com.jiespace.domain;

import lombok.Data;

import java.util.Date;

@Data
public class TestOrder {
    private int id;
    private String orderNo;
    private Date createtime;
    private int orderstatus;
    private int orderprice;

}
