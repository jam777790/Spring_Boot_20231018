
package com.example.demo.controller;

import java.util.List;

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

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("data", " 반갑습니다.");
        return "hello";
    }

    @GetMapping("/hello2")
    public String hello2(Model model) {
        model.addAttribute("data", " 홍길동님.");
        model.addAttribute("data1", " 반갑습니다.");
        model.addAttribute("data2", " 오늘.");
        model.addAttribute("data3", " 날씨는.");
        model.addAttribute("data4", " 매우 좋습니다.");
        return "hello2";
    }

    // 전체 사용자 목록 출력
    @GetMapping("/testdb")
    public String getAllTestDBs(Model model) {
        List<TestDB> users = testService.findAll();

        model.addAttribute("users", users);

        System.out.println("데이터 출력 디버그 : " + users);

        return "testdb";
    }
}
