package com.blog.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    // 관리자 권한 no 외래키
    private int userNo;
    // cate 번호 외래키
    private int CateNumber;

    private String title;
    private String contents;
    private Date regDate;
}
