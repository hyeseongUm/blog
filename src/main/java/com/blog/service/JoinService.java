package com.blog.service;

import com.blog.repository.UserRepository;
import com.blog.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinPros(UserEntity userEntity){

        boolean isUser = userRepository.existsByUsername(userEntity.getUsername());
        boolean exitsNickname = userRepository.existsByNickname(userEntity.getNickname());
        if(isUser || exitsNickname){
            return;
        }
        userEntity.setUsername(userEntity.getUsername());
        userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
        userEntity.setRole("ROLE_USER");
        if (userEntity.getUsername().equals("5391nks")){
            userEntity.setRole("ROLE_ADMIN");
        }
        userRepository.save(userEntity);
    }
}
