package com.example.springSecurity.dao;

import com.example.springSecurity.entity.Member;
import com.example.springSecurity.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberDao implements UserDetailsService {
    private final MemberRepository memberRepository;

    public void saveMember(Member member){
        memberRepository.save(member);
    }

    @Override
    public Member loadUserByUsername(String userId) throws UsernameNotFoundException {
        return memberRepository.findByUserId(userId);
    }
}
