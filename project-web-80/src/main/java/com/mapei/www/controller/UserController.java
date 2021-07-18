package com.mapei.www.controller;

import com.mapei.www.result.ExceptionMsg;
import com.mapei.www.result.ResponseData;
import com.mapei.www.service.TbUserService;
import com.mapei.www.util.Assgin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    TbUserService tbUserService;



    @RequestMapping(value = "/api2/user/getUser")
    public ResponseData getUser(@RequestParam(value="username", required=true) String username) throws Exception
    {
        Object user = tbUserService.getUser(username);

//        Map<String, Object> addProperties = new HashMap();
//        addProperties.put("token","aaaaaaaaaaaaaaa121212432534");
//        Object loginInf = Assgin.main(user, addProperties);


        return new ResponseData(ExceptionMsg.SUCCESS, user);
        //return restTemplate.getForObject(REST_URL_PREFIX + "/user/get/" + id, TbUser.class);
    }

}
