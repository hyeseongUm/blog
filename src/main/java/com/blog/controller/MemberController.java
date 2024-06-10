package com.blog.controller;

import com.blog.dto.MemberDTO;
import com.blog.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService joinService;

    @GetMapping("/join")
    public String join(){
        return "user/join.html";
    }

    @PostMapping("/join")
    public String joinMember(MemberDTO joinDTO){
        joinService.join(joinDTO);
        // validator 해서 빈칸 이런거 확인하기

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
        return "user/login.html";
    }
}
