package com.mapei.www.service;


import com.mapei.www.config.FeignLogConfig;
import com.mapei.www.entity.TbUser;
import com.mapei.www.service.impl.UserFallbackServieImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(
        name="project-zuul-gateway-9501",
        configuration = FeignLogConfig.class,
        fallbackFactory= UserFallbackServieImpl.class
)
public interface IUserService {

    @RequestMapping(value = "/gateway/user/user/getUser")
    public Object getUser(@RequestParam(value="username", required=true) String username);

    @RequestMapping(value = "/gateway/user/user/list")
    public List<TbUser> list();

    @RequestMapping(value = "/gateway/user/user/get/{id}")
    public TbUser findById(@PathVariable("id") String id);


}
