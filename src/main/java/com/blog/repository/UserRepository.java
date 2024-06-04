package com.blog.repository;

import com.blog.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    boolean existsByUsername(String username);
    boolean existsByNickname(String nickname);

    UserEntity findByUsername(String username);

}
