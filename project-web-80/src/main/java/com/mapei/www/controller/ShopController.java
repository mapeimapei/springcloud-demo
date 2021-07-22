package com.mapei.www.controller;


import com.mapei.www.result.ExceptionMsg;
import com.mapei.www.result.ResponseData;

import com.mapei.www.service.IShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/shop")
public class ShopController {

    @Autowired
    IShopService iShopService;


    @RequestMapping(value = "/demo2")
    public ResponseData demo2() throws Exception {
        String ss = iShopService.demo2();
        return new ResponseData(ExceptionMsg.SUCCESS, ss);
    }


    /**
     * @return
     */
    @PostMapping("/cart/addCart")
    public ResponseData addCart(@RequestBody Object cart) throws Exception{
        Integer n = iShopService.addCart(cart);
        if (n > 0) {
            return new ResponseData(ExceptionMsg.SUCCESS);
        } else {
            return new ResponseData(ExceptionMsg.FAILED);
        }
    };

    /**
     * 获取商品列表
     *
     * @return
     */
    @GetMapping("/cart/getCartList/{user_id}")
    public ResponseData getCartList(@PathVariable("user_id") String user_id) throws Exception{
        List<Map<String, Object>> list = iShopService.getCartList(user_id);
        return new ResponseData(ExceptionMsg.SUCCESS, list);
    };


    /**
     * 获取商品列表
     *
     * @return
     */
    @GetMapping("/products")
    public ResponseData getProducts() throws Exception {
        List<Map<String,Object>> list = iShopService.getProducts();
        return new ResponseData(ExceptionMsg.SUCCESS, list);

    };

    /**
     * 删除购物车
     *
     * @param params
     * @return
     */

    @PostMapping("/cart/deleteCart")
    public ResponseData deleteCart(@RequestBody Map params) throws Exception{

        String userid = (String) params.get("userid");
        ArrayList<String> productids = (ArrayList<String>) params.get("productids");

        System.out.println(userid);

        Integer n = iShopService.deleteCart(params);
        System.out.println(n);
        if (n > 0) {
            return new ResponseData(ExceptionMsg.SUCCESS);
        } else {
            return new ResponseData(ExceptionMsg.FAILED);
        }
    };

    /**
     * 生成订单
     *
     * @return
     */
    @PostMapping("/order/addOrder")
    public ResponseData addOrder(@RequestBody Map params) throws Exception{

        String uuid = iShopService.addOrder(params);
        if (uuid.length() > 0) {
            Map<String, String> res = new HashMap<>();
            res.put("orderid", uuid);
            return new ResponseData(ExceptionMsg.SUCCESS,res);
        } else {
            return new ResponseData(ExceptionMsg.FAILED);
        }


    };


    /**
     * 查询订单详情
     *
     * @param params
     * @return
     * @throws Exception
     */
    @PostMapping("/order/getOrdersDetailsById")
    public ResponseData queryOrdersDetails(@RequestBody Map params) throws Exception{
        Map<String,Object> orderDetails = iShopService.queryOrdersDetails(params);
        return new ResponseData(ExceptionMsg.SUCCESS, orderDetails);
    };


    /**
     * 获取商品列表
     *
     * @return
     */
    @GetMapping("/order/getOrderList/{userid}")
    public ResponseData getOrderList(@PathVariable("userid") String userid) throws Exception {

        List<Object> list = iShopService.getOrderList(userid);
        return new ResponseData(ExceptionMsg.SUCCESS, list);


    };

    /**
     * 删除订单
     *
     * @param params
     * @return
     * @throws Exception
     */
    @PostMapping("/order/deleteOrder")
    public ResponseData deleteOrder(@RequestBody Map params) throws Exception{
        Integer n = iShopService.deleteOrder(params);
        if (n > 0) {
            return new ResponseData(ExceptionMsg.SUCCESS);
        } else {
            return new ResponseData(ExceptionMsg.FAILED);
        }
    };

    /**
     * 删除订单中的商品
     *
     * @param params
     * @return
     * @throws Exception
     */
    @PostMapping("/order/deleteProductInOrderDetails")
    public ResponseData deleteProductInOrderDetails(@RequestBody Map params) throws Exception{
        Integer n = iShopService.deleteProductInOrderDetails(params);
        if (n > 0) {
            return new ResponseData(ExceptionMsg.SUCCESS);
        } else {
            return new ResponseData(ExceptionMsg.FAILED);
        }

    };



}
