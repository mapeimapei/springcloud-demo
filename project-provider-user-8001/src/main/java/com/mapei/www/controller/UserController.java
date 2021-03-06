package com.mapei.www.controller;


import com.mapei.www.entity.User;
import com.mapei.www.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/getUser", method = RequestMethod.GET)
    public Object getUser(@RequestParam(value="username", required=true) String username) throws Exception
    {
        User user = userService.getUser(username);
        System.out.println(user);
        return user;
    }


}
