package com.example.springSecurity.dao;

import com.example.springSecurity.domain.Role;
import com.example.springSecurity.entity.Member;
import com.example.springSecurity.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberDao implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder encoder;

    public void saveMember(Member member){
        member.setPassword(encoder.encode(member.getPassword()));
        member.setRole(Role.USER);
        memberRepository.save(member);
    }

    @Override
    public Member loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.findByUserId(username);
    }
}
