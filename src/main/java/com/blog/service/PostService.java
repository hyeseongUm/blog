package com.blog.service;

import com.blog.dto.PostDTO;
import com.blog.dto.PostListDTO;
import com.blog.entity.Post;
import com.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<PostListDTO> list(Long cateNumber){
        List<Post> findPostListByCateNumber = postRepository.findAllByCateNumber(cateNumber);
        List<PostListDTO> postLists = new ArrayList<>();

        for (Post post : findPostListByCateNumber) {
            PostListDTO postListDTO = PostListDTO.builder()
                    .cateNumber(post.getCateNumber())
                    .title(post.getTitle())
                    .regDate(new SimpleDateFormat("yyyy-MM-dd").format(post.getRegDate()))
                    .build();

            postLists.add(postListDTO);
        }

        return postLists;
    }

    public PostDTO detail(Long id){
        Optional<Post> getPost = postRepository.findById(id);
        if (getPost.isPresent()){
            Post data = getPost.get();

            return PostDTO.builder().post(data).build();
        }else {
            return null; // 에러 날리기 "없는 포스트"
        }
    }

    public void write(PostDTO postDTO){
        if (!postDTO.getTitle().isEmpty()){
            Post post = new Post();
            post.setTitle(postDTO.getTitle());
            post.setContents(postDTO.getContents());
            post.setRegDate(new Date());
            post.setCateNumber(postDTO.getCateNumber());
        }
    }

    public void edit(Long id, PostDTO postDTO){
        if(postRepository.existsById(id)){
            Post post = new Post();
            post.setTitle(postDTO.getTitle());
            post.setContents(postDTO.getContents());
            post.setCateNumber(postDTO.getCateNumber()); // cate고리가 같으면 set 안해도 됨
        }
    }


}
