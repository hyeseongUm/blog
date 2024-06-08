package com.blog.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public class JoinDTO {

    private String username;
    private String password;
    private String name;
    private String nickname;


    public static class JoinBuilder{
        private String username;
        private String password;
        private String name;
        private String nickname;

        public JoinBuilder username(String id){
            this.username = id;
            return this;
        }


        public JoinDTO build(){
            return new JoinDTO(username,password,name,nickname);
        }


    }

}
