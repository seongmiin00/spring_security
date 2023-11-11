package com.example.springSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
    @GetMapping("/loginForm")
    public String goLogin(){
        return "/members/loginForm";
    }

    @GetMapping("/joinForm")
    public String goJoin(){
        return "/members/joinForm";
    }
}

