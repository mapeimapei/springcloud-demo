package com.mapei.www.service;

import com.mapei.www.entity.TbUser;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
public interface TbUserService {
    @RequestMapping(value = "/gateway/user/user/list")
    public List<TbUser> list();

    @RequestMapping(value = "/gateway/user/user/get/{id}")
    public TbUser findById(@PathVariable("id") String id);




}
