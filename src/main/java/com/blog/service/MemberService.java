package com.blog.service;

import com.blog.dto.MemberDTO;
import com.blog.repository.MemberRepository;
import com.blog.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void join(MemberDTO memberDTO){

        Member member = new Member();
        Optional<Member> isUser = memberRepository.findByUsername(memberDTO.getUsername());
        if(isUser.isEmpty()){
            return;
        }
        member.setUsername(memberDTO.getUsername());
        member.setPassword(bCryptPasswordEncoder.encode(memberDTO.getPassword()));
        member.setRole("ROLE_USER");
        if (memberDTO.getUsername().equals("nks0561")){
            member.setRole("ROLE_ADMIN");
        }
        memberRepository.save(member);
    }
}
