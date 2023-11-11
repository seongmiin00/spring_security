package com.example.springSecurity.dao;

import com.example.springSecurity.entity.Member;
import com.example.springSecurity.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberDao {
    private final MemberRepository memberRepository;
    private final Member member;

    public void saveMember(Member member){
        memberRepository.save(member);
    }

    public Optional<Member> findUser(String userId){
        return memberRepository.findByUserId(userId);
    }
}
