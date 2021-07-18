package com.mapei.www.dao;

import com.mapei.www.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserServiceDao {

    public User getUser(String username);
    public Integer addUser(User user);


}
