package com.mapei.www.service.impl;

import com.mapei.www.dao.TbUserDao;
import com.mapei.www.service.ITbUserService;
import com.mapei.www.entity.TbUser;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Component
public class TbUserService implements ITbUserService {

    @Autowired
    TbUserDao tbUserDao;

    public List<TbUser> SelectTbUser(){
        List ls = tbUserDao.SelectTbUser();
        return ls;


    }

    public TbUser findById(String id){
        TbUser user = tbUserDao.findById(id);
        return user;

    }

}
