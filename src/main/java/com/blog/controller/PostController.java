package com.blog.controller;

import com.blog.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    @GetMapping("")
    public String list(Post postEntity, Model model){
        return "pages/list.html";
    }

    @GetMapping("{no}")
    public String detail(Post postEntity, Model model){
        return "pages/detail.html";
    }

    @GetMapping("write")
    public String writeGet(){
        return "pages/write.html";
    }

    @PostMapping("write")
    public String writePost(Post postEntity){
        return "redirect:/"; //디테일 페이지? 아니면 리스트 페이지?
    }

    @GetMapping("{no}/edit")
    public String updateGet(@PathVariable int no, Model model){
        return "pages/update.html";
    }

    @PostMapping("{no}/edit")
    public String updatePost(@PathVariable int no){
        return "redirect:/"+no; //디테일 페이지
    }
}
