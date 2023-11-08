package com.example.springSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration { //spring security 버전 업데이트 후부터 filter chain 메소드를 직접 구현해 줘야함
    //메소드 직접 구현후 빈으로 등록해 줘야함
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
//
//
//        return httpSecurity
//    }
}
