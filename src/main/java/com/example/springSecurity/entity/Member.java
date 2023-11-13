package com.example.springSecurity.entity;

import com.example.springSecurity.domain.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Member implements UserDetails {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { //권한 여부 가져오기
        return null;
    }

    @Override
    public String getUsername() {
        return userId;
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public boolean isAccountNonExpired() { //계정 만료 여부
        return true; //true -> 만료 X
    }

    @Override
    public boolean isAccountNonLocked() { //계정 잠금 여부
        return true; //true -> 잠금 X
    }

    @Override
    public boolean isCredentialsNonExpired() { //패스워드 만료 여부
        return true; //true -> 만료 X
    }

    @Override
    public boolean isEnabled(){ //계정 사용 가능 여부
        return true; //true -> 사용 가능
    }
}
