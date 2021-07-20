package com.mapei.www.controller;


import com.mapei.www.entity.TbUser;
import com.mapei.www.result.ExceptionMsg;
import com.mapei.www.result.ResponseData;
import com.mapei.www.service.ApiMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

    @Autowired
    ApiMainService apiMainService;


    @RequestMapping(value = "/api2/blog/demo")
    public ResponseData demo() throws Exception {
        String ss = apiMainService.demo();
        return new ResponseData(ExceptionMsg.SUCCESS, ss);
    }


}
