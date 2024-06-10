package com.blog.dto;

import com.blog.entity.Post;
import lombok.Builder;
import lombok.Getter;

import java.text.SimpleDateFormat;

@Getter
public class PostListDTO {
    private Long id;
    private Long cateNumber;
    private String title;
    private String regDate;

    @Builder
    public PostListDTO(Long id, Long cateNumber, String title, String regDate){
        this.id = id;
        this.cateNumber = cateNumber;
        this.title = title;
        this.regDate = regDate;
    }

}
