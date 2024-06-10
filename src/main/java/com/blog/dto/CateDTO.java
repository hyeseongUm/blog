package com.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CateDTO {
    private String cateName;
    private Long parentNo;
    private int isSubCate;
}
