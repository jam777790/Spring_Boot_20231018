package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.domain.TestDB;
import com.example.demo.model.service.TestService;


@Controller
public class DemoController {

     @Autowired
    TestService testService;

    @GetMapping("/hello") // 전송 방식 GET
    public String hello(Model model) {
        model.addAttribute("data", " 반갑습니다."); // model 설정
        return "hello"; // hello.html 연결    
    }

    @GetMapping("/hello2")
    public String hello2(Model model) {
        model.addAttribute("data", " 홍길동님.");
        model.addAttribute("data1", " 반갑습니다.");
        model.addAttribute("data2", " 오늘.");
        model.addAttribute("data3", " 날씨는.");
        model.addAttribute("data4", " 매우 좋습니다."); // model 설정
        return "hello2";
    }

    // DemoController 클래스 아래 객체 주입
    // 하단에 맵핑 이어서 추가
    @GetMapping("/testdb")
    public String getAllTestDBs(Model model) {
        TestDB test = testService.findByName("홍길동");
        model.addAttribute("data4", test);
        System.out.println("데이터 출력 디버그 : " + test);
        return "testdb";
    }
}

