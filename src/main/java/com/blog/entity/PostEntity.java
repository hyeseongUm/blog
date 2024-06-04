package com.blog.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    private String cate;
    private String subCate;
    private String title;
    private String contents;
    private String image;
}
