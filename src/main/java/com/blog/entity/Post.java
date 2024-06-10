package com.blog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 관리자 권한 no 외래키
    @Column
    private int userNo;

    // cate 번호 외래키
    @Column
    private Long cateNumber;

    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String contents;

    @Column(updatable = true)
    private Date regDate;
}
