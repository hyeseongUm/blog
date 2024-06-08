package com.blog.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class CateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    // cate : not null
    private String cateName;

    // 서브카테 추가할 때 큰 카테에 no 확인하여 카테고리명을 뽑아오기 위해
    // cate no 외래키로 걸기
    private int parentNo;

    // not null 0:큰 카테, 1:서브카테
    private int isSub;
}
