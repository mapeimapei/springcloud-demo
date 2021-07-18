package com.mapei.www.service;

import com.mapei.www.entity.User;

public interface IUserService {

    public User getUser(String username);

    public Integer addUser(User user);

}
