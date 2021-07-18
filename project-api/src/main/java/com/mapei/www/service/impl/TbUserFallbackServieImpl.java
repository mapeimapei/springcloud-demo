package com.mapei.www.service.impl;

import com.mapei.www.entity.TbUser;
import com.mapei.www.service.TbUserService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Component // 不要忘记添加，不要忘记添加
public class TbUserFallbackServieImpl implements FallbackFactory<TbUserService>
{
    @Override
    public TbUserService create(Throwable throwable)
    {
        return new TbUserService() {

            @Override
            public Object getUser(String username){
                return "AAA失败了";
            }


            @Override
            public List<TbUser> list(){
                TbUser user = new TbUser();
                user.setName("服务器内部出现错误，导致findById接口异常，客户端提供的降级信息");
                List<TbUser> ll = new ArrayList();
                ll.add(user);
                return ll;
            }

            @Override
            public TbUser findById(String id){
                TbUser user = new TbUser();
                user.setName("服务器内部出现错误，导致findById接口异常，客户端提供的降级信息");
                return user;
            }

        };
    }
}












