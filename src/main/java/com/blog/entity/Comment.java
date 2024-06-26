package com.blog.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    // user 의 회원 번호 외래키
    private int userNo;

    // cate 번호 외래키
    private int cateNo;
    private String contents;
    private Date regDate;
}
