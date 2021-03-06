package com.mapei.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.mapei.www.entity.TbUser;
import com.mapei.www.service.impl.TbUserService;




@RestController
public class TbuserController {

    @Autowired
    private TbUserService tbUserService;

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public List<TbUser> SelectTbUser() throws Exception{
        return tbUserService.SelectTbUser();
    }

    @RequestMapping(value = "/user/get/{id}", method = RequestMethod.GET)
    public TbUser findById(@PathVariable("id") String id) throws Exception {
        TbUser user = tbUserService.findById(id);
        if (user != null){
            return user;
        }else{

            throw new Exception("未查询到信息");
        }


    }


}
