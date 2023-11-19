package com.example.springSecurity.controller;

import com.example.springSecurity.dao.MemberDao;
import com.example.springSecurity.dto.UserLoginDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import com.example.springSecurity.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberDao dao;

    @GetMapping("/loginForm")
    public String goLogin(Model model){
        model.addAttribute("memberLoginDto", new UserLoginDto());
        return "/members/loginForm";
    }

    @GetMapping("/joinForm")
    public String goJoin(Model model){
        model.addAttribute("memberJoinDto", new Member());
        return "/members/joinForm";
    }

    @PostMapping("/join")
    public String memberJoin(@ModelAttribute("memberJoinDto") Member member,
                             @RequestParam("first") String first, @RequestParam("second") String second, @RequestParam("third") String third){
        String phone = first + "-" + second + "-" + third;
        member.setPhoneNum(phone);
        dao.saveMember(member);
        return "redirect:/";
    }

    @GetMapping("/success")
    public String loginSuccess(@AuthenticationPrincipal Member member, Model model){ //@AuthenticationPrincipal을 이용하여 securityContext안에 있는 인증객체를 가져와 저장한다
        if (member != null){
            model.addAttribute("userInfo", member);
        }

        return "/success";
    }
}

