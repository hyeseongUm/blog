package com.blog.dto;

import com.blog.entity.Post;
import lombok.Builder;
import lombok.Getter;

import java.text.SimpleDateFormat;

@Getter
public class PostDTO {
    private Long id;
    private Long cateNumber;
    private String title;
    private String contents;
    private String regDate;

    @Builder
    public PostDTO(Post post){
        this.id = post.getId();
        this.cateNumber = post.getCateNumber();
        this.title = post.getTitle();
        this.contents = post.getContents();
        this.regDate = new SimpleDateFormat("yyyy-MM-dd").format(post.getRegDate());
    }
}
