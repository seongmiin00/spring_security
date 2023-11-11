package com.example.springSecurity.repository;

import com.example.springSecurity.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> { //JpaRepository를 상속받을 인터페이스를 작성
    Optional<Member> findByUserId(String userId);
}
