package com.mapei.www.controller;

import com.mapei.www.exception.ValidatorUtils;
import com.mapei.www.result.ExceptionMsg;
import com.mapei.www.result.ResponseData;
import com.mapei.www.service.IBlogService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cms")
public class BlogController {
    @Autowired
    IBlogService iBlogService;

    @RequestMapping(value = "/demo")
    public ResponseData demo() throws Exception {
        String ss = iBlogService.demo();
        return new ResponseData(ExceptionMsg.SUCCESS, ss);
    }

    /**
     * @return
     */
    @GetMapping("post/getPosts")
    //@RequiresAuthentication
    public ResponseData getPosts() {
        List<Object> cs = iBlogService.getPosts();
        System.out.println(cs);
        String[] fields = {
                "name",
                "id",
                "user_name",
                "created_at",
                "summary"
        };
        return new ResponseData(ExceptionMsg.SUCCESS, cs, fields);
    }

    /**
     * @param id
     * @return
     */
    @GetMapping("post/getSingleById/{id}")
    public ResponseData getSingleById(@PathVariable String id) {

        System.out.println(id);

        Object post = iBlogService.getSingleById(id);
        return new ResponseData(ExceptionMsg.SUCCESS, post);
    }

    @PostMapping("post/addSingle")
    public ResponseData addSingle(@RequestBody Object post) {
        ValidatorUtils.validateEntity(post);
        Object ps = iBlogService.addSingle(post);
        return new ResponseData(ExceptionMsg.SUCCESS, ps);
    }

    @PostMapping("/post/deleteSingle")
    public ResponseData login2(@RequestBody Map params) {


        Integer n = iBlogService.deleteSingle(params);
        if (n > 0) {
            return new ResponseData(ExceptionMsg.SUCCESS);
        } else {
            return new ResponseData(ExceptionMsg.FAILED);
        }


    }


}
