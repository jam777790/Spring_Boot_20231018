package com.example.demo.model.dto;
import java.security.Principal;

import com.example.demo.model.domain.Member;
import com.example.demo.model.service.MemberService;

// API 응답용 DTO : 화면(JSON)에 내보낼 값만 담는다 → password 는 빠진다
public record MemberResponse(Long id, String username, String name, String role) {
public static MemberResponse from(Member member) { // 엔티티 → 응답 DTO 변환
return new MemberResponse(member.getId(), member.getUsername(),
member.getName(), member.getRole());
}

public MemberResponse me(Principal principal, MemberService memberService) { // 반환형 Member → MemberResponse
Member member = memberService.findByUsername(principal.getName());
return MemberResponse.from(member); // 엔티티 대신 DTO 반환
}
}
