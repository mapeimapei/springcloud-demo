package com.mapei.www.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mapei.www.result.ExceptionMsg;
import com.mapei.www.result.ResponseData;
import com.mapei.www.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mapei.www.utils.Assgin;
import com.mapei.www.utils.Utils;

import com.mapei.www.entity.TbUser;

@RestController
public class TbUserController {
    @Autowired
    IUserService iUserService;

//    @Autowired
//    private RestTemplate restTemplate;


    //private static final String REST_URL_PREFIX = "http://user.mapei.com:8001";

    @RequestMapping(value = "/api2/user/simgle_format")
    public String SimgleFormat(String patrern, String value) {
        //###,###.###kg  11111111111111.013232323 11,111,111,111,111.014kg
        double val = Double.parseDouble(value);
        String ss = Utils.SimgleFormat(patrern,val);
        return ss;
    }



    @RequestMapping(value = "/api2/user/base64_encode")
    public String base64_encode(String str) {
        String ss = Utils.base64_encode(str,"nihao",3);
        return ss;
    }

    @RequestMapping(value = "/api2/user/base64_decode")
    public String base64_decode(String str) {
        String ss = Utils.base64_decode(str,3);
        return ss;
    }


    /**
     * 使用 使用restTemplate访问restful接口非常的简单粗暴无脑。 (url, requestMap,
     * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
     */

    @RequestMapping(value = "/api2/user/get2")
    public String get2() {
        return "11111";
    }



    @RequestMapping(value = "/api2/user/get/{id}")
    public Object findById(@PathVariable("id") String id) throws Exception
    {
        TbUser user = iUserService.findById(id);
        Map<String, Object> addProperties = new HashMap();
        addProperties.put("token","aaaaaaaaaaaaaaa121212432534");
        Object loginInf = Assgin.main(user, addProperties);
        return new ResponseData(ExceptionMsg.SUCCESS, loginInf);
        //return restTemplate.getForObject(REST_URL_PREFIX + "/user/get/" + id, TbUser.class);
    }


    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/api2/user/list")
    public ResponseData list() throws Exception
    {
        List<TbUser> ll = iUserService.list();
        return new ResponseData(ExceptionMsg.SUCCESS,ll);
        //return restTemplate.getForObject(REST_URL_PREFIX + "/user/list", List.class);
    }












}
