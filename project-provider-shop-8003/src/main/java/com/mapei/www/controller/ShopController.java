package com.mapei.www.controller;

import static com.alibaba.fastjson.JSON.toJSONString;

import com.alibaba.fastjson.JSONObject;
import com.mapei.www.entity.Cart;
import com.mapei.www.entity.Order;
import com.mapei.www.entity.OrderDetails;
import com.mapei.www.entity.Products;
import com.mapei.www.service.impl.CartService;
import com.mapei.www.service.impl.OrderDetailsService;
import com.mapei.www.service.impl.OrderService;
import com.mapei.www.service.impl.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
//@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ProductsService productsService;

    @Autowired
    CartService cartService;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderDetailsService orderDetailsService;


    @RequestMapping(value = "/demo2", method = RequestMethod.GET)
    public String demo2() throws Exception {
        return "shop";
    }


    /**
     * @return
     */
    @PostMapping("cart/addCart")
    public Integer addCart(@RequestBody Cart cart) throws Exception {
        Integer selectCart = cartService.selectCart(cart);
        Integer n;
        if (selectCart > 0) {
            System.out.println("更新");
            n = cartService.updateCart(cart);

        } else {
            System.out.println("add");
            n = cartService.addCart(cart);
        }
        return n;
    }

    /**
     * 获取商品列表
     *
     * @return
     */
    @GetMapping("cart/getCartList/{user_id}")
    public List<Map<String, Object>> getCartList(@PathVariable("user_id") String user_id) throws Exception {
        List<Map<String, Object>> list = cartService.getCartList(user_id);
        return list;
    }


    /**
     * 获取商品列表
     *
     * @return
     */
    @GetMapping("products")
    public List<Products> getProducts() throws Exception {
        List<Products> list = productsService.getProducts();
        return list;
    }

    /**
     * 删除购物车
     *
     * @param params
     * @return
     */

    @PostMapping("cart/deleteCart")
    public Integer deleteCart(@RequestBody Map params) throws Exception {
        String userid = (String) params.get("userid");
        System.out.println("############"+userid);
        ArrayList<String> productids = (ArrayList<String>) params.get("productids");
        System.out.println("############"+productids.get(0));
        Integer n = cartService.deleteCart(userid, productids);
        System.out.println("######################");
        System.out.println(n);
        return n;
    }

    /**
     * 生成订单
     *
     * @return
     */
    @PostMapping("order/addOrder")
    public String addOrder(@RequestBody Map params) throws Exception {
        String fast = (String) params.get("fast");
        String userid = (String) params.get("userid");


        System.out.println("fast"+fast);
        System.out.println("userid"+userid);


        List<Products> productList = (List<Products>) params.get("productList");

        Order order = new Order();
        String uuid = UUID.randomUUID().toString();
        String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
        String created_at = new SimpleDateFormat(TIME_FORMAT).format(new Date());

        order.setOrderid(uuid);
        order.setUserid(userid);
        order.setOrderdate(created_at);

        Double amount = 0.0;
        for (Object obj : productList) {
            Products products = JSONObject.parseObject(toJSONString(obj), Products.class);
            Double price = products.getListprice() * products.getQuantity();
            amount += price;
        }

        order.setAmount(amount);

        Integer n = orderService.addOrder(userid, productList, order, fast);
        System.out.println(n);
        if(n > 0){
           return uuid;
        }
        return "";
    }


    /**
     * 查询订单详情
     *
     * @param params
     * @return
     * @throws Exception
     */
    @PostMapping("order/getOrdersDetailsById")
    public OrderDetails queryOrdersDetails(@RequestBody Map params) throws Exception {
        String userid = (String) params.get("userid");
        String orderid = (String) params.get("orderid");
        OrderDetails orderDetails = orderDetailsService.queryOrdersDetails(userid, orderid);
        return orderDetails;
    }


    /**
     * 获取商品列表
     *
     * @return
     */
    @GetMapping("order/getOrderList/{userid}")
    public List<Order> getOrderList(@PathVariable("userid") String userid) throws Exception {
        List<Order> list = orderService.getOrderList(userid);
        return list;
    }

    /**
     * 删除订单
     *
     * @param params
     * @return
     * @throws Exception
     */
    @PostMapping("order/deleteOrder")
    public Integer deleteOrder(@RequestBody Map params) throws Exception {
        String userid = (String) params.get("userid");
        String orderid = (String) params.get("orderid");
        Integer n = orderService.deleteOrder(userid, orderid);
        return n;
    }

    /**
     * 删除订单中的商品
     *
     * @param params
     * @return
     * @throws Exception
     */
    @PostMapping("order/deleteProductInOrderDetails")
    public Integer deleteProductInOrderDetails(@RequestBody Map params) throws Exception {
        String orderid = (String) params.get("orderid");
        String productid = (String) params.get("productid");
        Integer n = orderDetailsService.deleteProductInOrderDetails(orderid, productid);
        return n;
    }


}
