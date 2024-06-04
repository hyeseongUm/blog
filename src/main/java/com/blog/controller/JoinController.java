package com.blog.controller;

import com.blog.entity.UserEntity;
import com.blog.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoinController {

    @Autowired
    private JoinService joinService;

    @GetMapping("/join")
    public String join(){
        return "join.html";
    }

    @PostMapping("/join")
    public String joinReg(UserEntity userEntity){

        joinService.joinPros(userEntity);
        // validator 해서 빈칸 이런거 확인하기

        return "redirect:/login";
    }
}