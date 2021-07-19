package com.mapei.www.service;


import com.mapei.www.config.FeignLogConfig;
import com.mapei.www.entity.TbUser;
import com.mapei.www.service.impl.TbUserFallbackServieImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(name="project-zuul-gateway-9501") //,fallbackFactory= TbUserFallbackServieImpl.class
public interface ApiMainService extends TbUserService {



    @RequestMapping(value = "/gateway/user/user/getUser")
    public Object getUser(@RequestParam(value="username", required=true) String username);




}


