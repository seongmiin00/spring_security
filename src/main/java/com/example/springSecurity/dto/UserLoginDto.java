package com.example.springSecurity.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class UserLoginDto {
    private String userId;
    private String password;
}
