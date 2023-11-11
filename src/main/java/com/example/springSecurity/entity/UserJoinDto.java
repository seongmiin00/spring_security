package com.example.springSecurity.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class UserJoinDto {
    @Id @GeneratedValue
    @Column(name = "userNum")
    private Long id;
    private String userId;
    private String password;
    private String name;
    private String phoneNum;

    @Builder
    public UserJoinDto(String userId, String password, String name, String phoneNum){
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.phoneNum = phoneNum;
    }
}
