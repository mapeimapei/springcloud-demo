package com.mapei.www.service;


import com.alibaba.fastjson.JSONObject;
import com.mapei.www.config.FeignLogConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.alibaba.fastjson.JSON.toJSONString;

@Component
@FeignClient(name="project-zuul-gateway-9501",configuration = FeignLogConfig.class) //,configuration = FeignLogConfig.class,fallbackFactory= TbUserFallbackServieImpl.class
public interface IShopService {

    @RequestMapping(value = "/gateway/shop/demo2")
    public String demo2();



    /**
     * @return
     */
    @PostMapping("/gateway/shop/cart/addCart")
    public int addCart(@RequestBody Object cart);

    /**
     * 获取商品列表
     *
     * @return
     */
    @GetMapping("/gateway/shop/cart/getCartList/{user_id}")
    public List<Map<String, Object>> getCartList(@PathVariable("user_id") String user_id);


    /**
     * 获取商品列表
     *
     * @return
     */
    @GetMapping("/gateway/shop/products")
    public List<Map<String,Object>> getProducts();

    /**
     * 删除购物车
     *
     * @param params
     * @return
     */

    @PostMapping("/gateway/shop/cart/deleteCart")
    public Integer deleteCart(@RequestBody Map params);

    /**
     * 生成订单
     *
     * @return
     */
    @PostMapping("/gateway/shop/order/addOrder")
    public String addOrder(@RequestBody Map params);


    /**
     * 查询订单详情
     *
     * @param params
     * @return
     * @throws Exception
     */
    @PostMapping("/gateway/shop/order/getOrdersDetailsById")
    public Map<String,Object> queryOrdersDetails(@RequestBody Map params);


    /**
     * 获取商品列表
     *
     * @return
     */
    @GetMapping("/gateway/shop/order/getOrderList/{userid}")
    public List<Object> getOrderList(@PathVariable("userid") String userid);

    /**
     * 删除订单
     *
     * @param params
     * @return
     * @throws Exception
     */
    @PostMapping("/gateway/shop/order/deleteOrder")
    public int deleteOrder(@RequestBody Map params);

    /**
     * 删除订单中的商品
     *
     * @param params
     * @return
     * @throws Exception
     */
    @PostMapping("/gateway/shop/order/deleteProductInOrderDetails")
    public int deleteProductInOrderDetails(@RequestBody Map params);


}
