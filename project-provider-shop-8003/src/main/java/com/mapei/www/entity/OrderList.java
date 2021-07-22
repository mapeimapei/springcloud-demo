package com.mapei.www.entity;

import lombok.Data;

@Data
public class OrderList {
    private String orderid;
    private String productid;
    private Integer quantity;
    private Double unitcost;
    private Products products;
}
