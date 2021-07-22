package com.mapei.www.service;


import com.mapei.www.config.FeignLogConfig;
import com.mapei.www.entity.TbUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Component
@FeignClient(name = "project-zuul-gateway-9501", configuration = FeignLogConfig.class)
//,configuration = FeignLogConfig.class,fallbackFactory= TbUserFallbackServieImpl.class
public interface IBlogService {

    @RequestMapping(value = "/gateway/cms/demo")
    public String demo();


    /**
     * @return
     */
    @GetMapping("/gateway/cms/post/getPosts")
    public List<Object> getPosts();

    /**
     * @param id
     * @return
     */
    @GetMapping("/gateway/cms/post/getSingleById/{id}")
    public Object getSingleById(@PathVariable("id") String id);

    @PostMapping("/gateway/cms/post/addSingle")
    public Object addSingle(Object post);

    @PostMapping("/gateway/cms/post/deleteSingle")
    public Integer deleteSingle(Map params);

}
