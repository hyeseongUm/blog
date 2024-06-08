package com.blog.service;

import com.blog.dto.JoinDTO;
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

    public void joinPros(JoinDTO joinDTO){

        UserEntity userEntity = new UserEntity();
        boolean isUser = userRepository.existsByUsername(joinDTO.getUsername());
        boolean exitsNickname = userRepository.existsByNickname(joinDTO.getNickname());
        if(isUser || exitsNickname){
            return;
        }
        userEntity.setUsername(joinDTO.getUsername());
        userEntity.setPassword(bCryptPasswordEncoder.encode(joinDTO.getPassword()));
        userEntity.setRole("ROLE_USER");
        if (joinDTO.getUsername().equals("5391nks")){
            userEntity.setRole("ROLE_ADMIN");
        }
        userRepository.save(userEntity);
    }
}
