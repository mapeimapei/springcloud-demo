package com.mapei.www.service;

import com.mapei.www.entity.TbUser;
import java.util.List;


public interface ITbUserService {

    public List<TbUser> SelectTbUser();

    public TbUser findById(String id);

}
