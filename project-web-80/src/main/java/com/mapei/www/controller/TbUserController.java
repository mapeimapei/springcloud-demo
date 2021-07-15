package com.mapei.www.controller;

import java.util.List;

import com.mapei.www.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mapei.www.entity.TbUser;

@RestController
public class TbUserController {
    @Autowired
    TbUserService tbUserService;

    //private static final String REST_URL_PREFIX = "http://user.mapei.com:8001";

    /**
     * 使用 使用restTemplate访问restful接口非常的简单粗暴无脑。 (url, requestMap,
     * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
     */

    @RequestMapping(value = "/api2/user/get2")
    public String get2() {
        return "11111";
    }

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value = "/api2/user/get/{id}")
    public TbUser findById(@PathVariable("id") String id)
    {
        return tbUserService.findById(id);
        //return restTemplate.getForObject(REST_URL_PREFIX + "/user/get/" + id, TbUser.class);
    }


    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/api2/user/list")
    public List<TbUser> list()
    {
        return tbUserService.list();
        //return restTemplate.getForObject(REST_URL_PREFIX + "/user/list", List.class);
    }












}
