package com.blog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    @Column(unique = true)
    private String username;

    private String password;

    private String name;

    @Column(unique = true)
    private String nickname;

    private String role;
}
