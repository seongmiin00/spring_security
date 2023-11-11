package com.example.springSecurity.domain;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN("관리자"),
    USER("유저");

    private String roleTitle; //값을 저장할 인스턴스 변수
    Role(String role){ //생성자
        this.roleTitle = role;
    }
}
