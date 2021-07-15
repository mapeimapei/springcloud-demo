package com.mapei.www.service;


import com.mapei.www.entity.TbUser;
import com.mapei.www.service.impl.TbUserFallbackServieImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@FeignClient(name="project-user-8001",fallbackFactory= TbUserFallbackServieImpl.class)
public interface TbUserService {

    @RequestMapping(value = "/user/get/{id}")
    public TbUser findById(@PathVariable("id") String id);

    @RequestMapping(value = "/user/list")
    public List<TbUser> list();

}



