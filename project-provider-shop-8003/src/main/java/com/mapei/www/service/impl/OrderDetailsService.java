package com.mapei.www.service.impl;

import com.mapei.www.dao.OrderDetailsServiceDao;
import com.mapei.www.entity.OrderDetails;
import com.mapei.www.service.IOrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailsService implements IOrderDetailsService {

    @Autowired
    OrderDetailsServiceDao orderDetailsServiceDao;

    /**
     * 查询订单详情
     * @return 订单详情
     */
    public OrderDetails queryOrdersDetails(String userid, String orderid){
        OrderDetails orderDetails = orderDetailsServiceDao.queryOrdersDetails(userid,orderid);
        return orderDetails;
    }

    /**
     * 删除订单中的商品
     * @param orderid
     * @param productid
     * @return
     */
    public Integer deleteProductInOrderDetails(String orderid,String productid){
        Integer n = orderDetailsServiceDao.deleteProductInOrderDetails(orderid,productid);
        return n;
    }


}
