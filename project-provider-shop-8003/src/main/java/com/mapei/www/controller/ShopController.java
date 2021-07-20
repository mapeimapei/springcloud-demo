package com.mapei.www.controller;


//import com.mapei.www.entity.User;
//import com.mapei.www.service.impl.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {

//    @Autowired
//    UserService userService;

    @RequestMapping(value = "/demo2", method = RequestMethod.GET)
    public String demo2() throws Exception
    {
        return "shop";
    }


}
