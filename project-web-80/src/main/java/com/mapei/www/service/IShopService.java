package com.mapei.www.service;


import com.mapei.www.config.FeignLogConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(name="project-zuul-gateway-9501",configuration = FeignLogConfig.class) //,configuration = FeignLogConfig.class,fallbackFactory= TbUserFallbackServieImpl.class
public interface IShopService {

    @RequestMapping(value = "/gateway/shop/demo2")
    public String demo2();

}
