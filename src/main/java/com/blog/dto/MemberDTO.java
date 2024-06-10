package com.blog.dto;

import com.blog.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberDTO {

    private String username;
    private String password;
    private String name;

    @Builder
    public MemberDTO(Member member){
        this.username = member.getUsername();
        this.password = member.getPassword();
        this.name = member.getName();
    }




}
