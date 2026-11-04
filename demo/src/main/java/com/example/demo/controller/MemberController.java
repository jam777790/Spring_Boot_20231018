
package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.domain.Member;
import com.example.demo.model.dto.MemberForm;
import com.example.demo.model.service.MemberService;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    // 로그인 화면
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // 회원가입 화면
    @GetMapping("/signup")
    public String signupForm() {
        return "signup";
    }

    // 회원가입 처리
    @PostMapping("/signup")
    public String signup(MemberForm memberForm, Model model) {

        try {
            memberService.signup(memberForm);

        } catch (IllegalArgumentException e) {
            // 회원가입 실패 원인을 화면에 전달
            model.addAttribute("error", e.getMessage());
            return "signup";
        }

        // 회원가입 성공 시 로그인 화면으로 이동
        return "redirect:/login?signup";
    }

    // 마이페이지
    @GetMapping("/mypage")
    public String mypage(Principal principal, Model model) {

        Member member =
                memberService.findByUsername(principal.getName());

        model.addAttribute("member", member);

        return "mypage";
    }
}
