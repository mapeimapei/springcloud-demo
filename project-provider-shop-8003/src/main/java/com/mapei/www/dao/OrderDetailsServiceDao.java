package com.mapei.www.dao;

import com.mapei.www.entity.OrderDetails;
import org.springframework.stereotype.Component;

@Component
public interface OrderDetailsServiceDao {

    // 查询订单详情
    public OrderDetails queryOrdersDetails(String userid, String orderid);

    // 删除订单中的商品
    public Integer deleteProductInOrderDetails(String orderid,String productid);



}
