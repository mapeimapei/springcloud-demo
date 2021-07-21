package com.mapei.www.service;


import com.mapei.www.config.FeignLogConfig;
import com.mapei.www.entity.TbUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(name="project-zuul-gateway-9501",configuration = FeignLogConfig.class) //,configuration = FeignLogConfig.class,fallbackFactory= TbUserFallbackServieImpl.class
public interface IBlogService {

    @RequestMapping(value = "/gateway/blog/demo")
    public String demo();



}
