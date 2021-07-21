package com.mapei.www.service.impl;

import com.mapei.www.entity.TbUser;
import com.mapei.www.service.IUserService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component // 不要忘记添加，不要忘记添加
public class UserFallbackServieImpl implements FallbackFactory<IUserService>
{
    @Override
    public IUserService create(Throwable throwable)
    {
        return new IUserService() {

            @Override
            public Object getUser(String username){
                return "AAA失败了";
            }

            @Override
            public List<TbUser> list() {
                return null;
            }

            @Override
            public TbUser findById(String id) {
                return null;
            }

        };
    }
}













