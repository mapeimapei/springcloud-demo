package com.mapei.www.controller;


import com.mapei.www.entity.Post;
import com.mapei.www.service.impl.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/cms")
public class BlogController {

    @Autowired
    PostService postService;

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String demo() throws Exception {
        return "blog";
    }

    /**
     * @return
     */
    @GetMapping("/post/getPosts")
    public List<Post> getPosts() throws Exception {
        return postService.getPost();
    }

    /**
     * @param id
     * @return
     */
    @GetMapping("/post/getSingleById/{id}")
    public Post getSingleById(@PathVariable String id) throws Exception {
        return postService.queryPostById(id);
    }

    @PostMapping("/post/addSingle")
    public Post addSingle(@RequestBody Post post) {
        post.curTime();
        Post ps = null;
        if (post.getId().isEmpty() || post.getId() == null) {
            post.UUID();
            ps = postService.addSingle(post);
        } else {
            ps = postService.updateSingle(post);
        }
        return ps;
    }

    @PostMapping("/post/deleteSingle")
    public Integer deleteSingle(@RequestBody Map params) throws Exception {
        String id = (String) params.get("id");
        Integer n = postService.deleteSingle(id);
        return n;
    }

}
