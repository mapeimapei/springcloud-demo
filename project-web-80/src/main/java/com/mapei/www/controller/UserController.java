package com.mapei.www.controller;

import com.mapei.www.result.ExceptionMsg;
import com.mapei.www.result.ResponseData;
import com.mapei.www.service.TbUserService;
import com.mapei.www.util.Assgin;
import com.mapei.www.util.JWTUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    TbUserService tbUserService;


    @PostMapping("/api2/login")
    public ResponseData login(@RequestBody Map params) throws IllegalAccessException {
        String email = (String) params.get("account");
        String password = (String) params.get("passwd");
        System.out.println(email + password);
        if (password.isEmpty() || null == password) {
            throw new ValidationException("密码不能为空");
        }
        String passwd = new Md5Hash(password, "mapei", 2).toString();
        Map user = (Map) tbUserService.getUser(email);
        if (user.get("passwd").equals(passwd)) {
            user.put("token", JWTUtil.sign(email, passwd));
            String[] keys = {"user_id", "name", "email", "token", "admin"};
            return new ResponseData(ExceptionMsg.SUCCESS, user, keys);
        } else {
            return new ResponseData(ExceptionMsg.UNAUTHORIZED);
        }
    }

    @RequiresAuthentication
    @RequestMapping(value = "/api2/user/getUser")
    public ResponseData getUser(@RequestParam(value = "username", required = true) String username) throws Exception {
        Object user = tbUserService.getUser(username);
        return new ResponseData(ExceptionMsg.SUCCESS, user);
    }

}
