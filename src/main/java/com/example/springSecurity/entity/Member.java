package com.example.springSecurity.entity;

import com.example.springSecurity.domain.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Member {
    @Id @GeneratedValue
    @Column(name = "userNum")
    private Long id;
    private String userId;
    private String password;
    private String name;
    private String phoneNum;
    private boolean enabled; //탈퇴여부
    private Role role; //회원등급


    @Builder
    public Member(String userId, String password, String name, String phoneNum, boolean enabled, Role role){
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.phoneNum = phoneNum;
        this.enabled = enabled;
        this.role = role;
    }
}
