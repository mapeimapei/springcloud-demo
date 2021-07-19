package com.mapei.www.service;

import com.mapei.www.entity.TbUser;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
public interface UserService {

    @RequestMapping(value = "/gateway/user/user/getUser")
    public Object getUser(@RequestParam(value="username", required=true) String username);


}
