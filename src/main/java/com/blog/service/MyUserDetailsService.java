package com.blog.service;

import com.blog.dto.MyUserDetails;
import com.blog.entity.Member;
import com.blog.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private MemberRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member userEntity = userRepository.findByUsername(username);

        if(userEntity != null){
            return new MyUserDetails(userEntity);
        }

        return null;
    }
}
