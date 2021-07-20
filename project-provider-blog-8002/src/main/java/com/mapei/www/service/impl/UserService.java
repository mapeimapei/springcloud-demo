package com.mapei.www.service.impl;

import com.mapei.www.dao.UserServiceDao;
import com.mapei.www.entity.User;
import com.mapei.www.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService implements IUserService {

    @Autowired
    UserServiceDao userServiceDao;

    public User getUser(String username){

        System.out.println(username);

        return userServiceDao.getUser(username);
    }

    public Integer addUser(User user){

        return userServiceDao.addUser(user);

    }

}
