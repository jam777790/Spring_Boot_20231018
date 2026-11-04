
package com.example.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.domain.TestDB;
import com.example.demo.model.repository.TestRepository;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    // 이름으로 사용자 한 명 찾기
    public TestDB findByName(String name) {
        return testRepository.findByName(name);
    }

    // 모든 사용자 조회
    public List<TestDB> findAll() {
        return testRepository.findAll();
    }
}
