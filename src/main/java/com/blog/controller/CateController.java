package com.blog.controller;

import com.blog.dto.CateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CateController {

    @GetMapping("/category")
    public String cateList(){
        return "cate.html";
    }

    @PostMapping("/category")
    public String changeCate(CateDTO cateDTO){
        System.out.println(cateDTO);
        return "cate.html";
    }
}
