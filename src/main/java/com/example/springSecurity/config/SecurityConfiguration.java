package com.example.springSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration { //spring security 버전 업데이트 후부터 filter chain 메소드를 직접 구현해 줘야함
    //메소드 직접 구현후 빈으로 등록해 줘야함
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(AbstractHttpConfigurer::disable) //사이트간의 요청 위조 공격 방지. 쿠키를 통한 인증방식이 아니라면 csrf를 방어할 필요 X
                .authorizeHttpRequests(authorize -> authorize //특정 url에 대한 권한 설정
                        .requestMatchers("/join","/loginForm") //특정 요청과 일치하는 url에 대한 액세스 설정
                        .permitAll() //해당 url은 인증, 인가 없이 접근 가능
                        .anyRequest()//위쪽에서 설정한 url의 요청을 제외한 모든 요청에 대한 설정
                        .authenticated() //그 이외의 url은 인가는 필요없지만 인증은 필요함
                )
                .formLogin(formLogin -> formLogin // 폼 기반 로그인 설정
                        .loginPage("/loginForm") //로그인 페이지로 사용할 url 설
                        .loginProcessingUrl("/member/login") //로그인 로직 실행시킬 url
                        .defaultSuccessUrl("/index") //로그인 성공시 이동할 url
                        .failureUrl("/loginError") //로그인 실패시 작동
                        //.successHandler() //로그인 성공시 실행 시킬 로직
                )
                .logout(logout -> logout
                        .logoutUrl("/member/logout") //로그인 로직 실행 url
                        .logoutSuccessUrl("/loginForm") //로그인 성공시 이동할 url
                );

        return http.build();
    }
}
