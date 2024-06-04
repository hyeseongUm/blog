package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {

    @GetMapping("write")
    public String writeGet(){
        return "write.html";
    }

    @PostMapping("write")
    public String writePost(){
        return "redirect:/"; //디테일 페이지
    }

    @GetMapping("edit/{no}")
    public String updateGet(@PathVariable int no){
        return "update.html";
    }

    @PostMapping("edit/{no}")
    public String updatePost(@PathVariable int no){
        return "redirect:/"; //디테일 페이지
    }
}
