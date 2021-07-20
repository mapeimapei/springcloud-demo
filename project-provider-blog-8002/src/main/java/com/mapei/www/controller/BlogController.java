package com.mapei.www.controller;


//import com.mapei.www.entity.User;
//import com.mapei.www.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

//    @Autowired
//    UserService userService;

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String demo() throws Exception
    {
        return "blog";
    }


}
