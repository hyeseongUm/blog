package com.blog.controller;

import com.blog.dto.PostDTO;
import com.blog.entity.Post;
import com.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @GetMapping("")
    public String list(Long cateNumber, Model model){
        model.addAttribute("data",postService.list(cateNumber));

        return "pages/list.html";
    }

    @GetMapping("{id}")
    public String detail(@PathVariable Long id, Model model){
        model.addAttribute(postService.detail(id));

        return "pages/detail.html";
    }

    @GetMapping("write")
    public String writeGet(){
        return "pages/write.html";
    }

    @PostMapping("write")
    public String writePost(PostDTO postDTO){
        postService.write(postDTO);

        return "redirect:/"; //디테일 페이지? 아니면 리스트 페이지?
    }

    @GetMapping("{id}/edit")
    public String updateGet(@PathVariable Long id, Model model){
        model.addAttribute(postService.detail(id));

        return "pages/update.html";
    }

    @PostMapping("{id}/edit")
    public String updatePost(@PathVariable Long id, PostDTO postDTO){
        postService.edit(id, postDTO);

        return "redirect:/"+id; //디테일 페이지
    }
}
