package com.mapei.www.controller;


import com.mapei.www.result.ExceptionMsg;
import com.mapei.www.result.ResponseData;

import com.mapei.www.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {

    @Autowired
    IShopService iShopService;


    @RequestMapping(value = "/api2/shop/demo2")
    public ResponseData demo2() throws Exception {
        String ss = iShopService.demo2();
        return new ResponseData(ExceptionMsg.SUCCESS, ss);
    }


}
