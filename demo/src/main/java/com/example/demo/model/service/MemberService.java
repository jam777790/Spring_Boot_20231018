
package com.example.demo.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.domain.Member;
import com.example.demo.model.dto.MemberForm;
import com.example.demo.model.repository.MemberRepository;

@Service
public class MemberService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 관리자가 부여할 수 있는 권한
    private static final List<String> ROLES =
            List.of("USER", "MANAGER", "ADMIN");

    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }

    // 현재 로그인한 사용자 아이디
    private String getCurrentUsername() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null
                || !authentication.isAuthenticated()
                || authentication instanceof
                    org.springframework.security.authentication.AnonymousAuthenticationToken) {
            throw new IllegalStateException(
                    "로그인 정보를 확인할 수 없습니다.");
        }

        return authentication.getName();
    }

    // 회원가입
    public Member signup(MemberForm form) {
        if (isBlank(form.getUsername())
                || isBlank(form.getPassword())
                || isBlank(form.getName())) {
            throw new IllegalArgumentException(
                    "아이디, 비밀번호, 이름은 필수입니다.");
        }

        if (memberRepository.existsByUsername(form.getUsername())) {
            throw new IllegalArgumentException(
                    "이미 사용 중인 아이디입니다.");
        }

        Member member = new Member();
        member.setUsername(form.getUsername());
        member.setPassword(
                passwordEncoder.encode(form.getPassword()));
        member.setName(form.getName());
        member.setRole("USER");

        return memberRepository.save(member);
    }

    // 로그인 사용자 조회
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "회원 없음 : " + username));

        return User.builder()
                .username(member.getUsername())
                .password(member.getPassword())
                .roles(member.getRole())
                .build();
    }

    // 아이디로 회원 조회
    public Member findByUsername(String username) {
        return memberRepository.findByUsername(username)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "회원이 존재하지 않습니다 : " + username));
    }

    // 전체 회원 조회
    public List<Member> findAll() {
        return memberRepository.findAll(Sort.by("id"));
    }

    // 회원 검색: 아이디 또는 이름에 검색어가 포함된 회원 조회
    public List<Member> searchMembers(String keyword) {
        if (isBlank(keyword)) {
            return findAll();
        }

        String searchKeyword = keyword.trim();

        return memberRepository
                .findByUsernameContainingIgnoreCaseOrNameContainingIgnoreCase(
                        searchKeyword,
                        searchKeyword
                );
    }

    // 회원 권한 변경: 관리자만 가능
    @PreAuthorize("hasRole('ADMIN')")
    public Member changeRole(Long id, String newRole) {

        if (!ROLES.contains(newRole)) {
            throw new IllegalArgumentException(
                    "허용되지 않는 권한입니다 : " + newRole);
        }

        Member member = memberRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "회원이 존재하지 않습니다."));

        // 관리자 본인의 권한 변경 방지
        String currentUsername = getCurrentUsername();

        if (currentUsername.equals(member.getUsername())) {
            throw new IllegalArgumentException(
                    "자기 자신의 권한은 변경할 수 없습니다.");
        }

        member.setRole(newRole);
        return memberRepository.save(member);
    }

    // 회원 삭제: 관리자만 가능
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteMember(Long id) {

        Member member = memberRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "회원이 존재하지 않습니다."));

        // 관리자 본인의 계정 삭제 방지
        String currentUsername = getCurrentUsername();

        if (currentUsername.equals(member.getUsername())) {
            throw new IllegalArgumentException(
                    "자기 자신의 계정은 삭제할 수 없습니다.");
        }

        memberRepository.delete(member);
    }

    // ID로 회원 조회
    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }
}
