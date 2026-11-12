
package com.example.demo.model.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.domain.Member;
import com.example.demo.model.domain.Post;
import com.example.demo.model.dto.PostForm;
import com.example.demo.model.repository.MemberRepository;
import com.example.demo.model.repository.PostRepository;

@Service
public class PostService {

    // 페이지당 게시글 수
    private static final int PAGE_SIZE = 10;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private MemberRepository memberRepository;

    // 전체 게시글 목록 (최신 글 순서)
    public List<Post> findAll() {
        return postRepository.findAll(
            Sort.by(Sort.Direction.DESC, "id")
        );
    }

    // 게시글 작성
    public Post write(PostForm form, String username) {

        validate(form);

        Member author = memberRepository.findByUsername(username)
            .orElseThrow(() ->
                new IllegalArgumentException("회원이 존재하지 않습니다.")
            );

        Post post = new Post();

        post.setTitle(form.getTitle().trim());
        post.setContent(form.getContent());
        post.setAuthor(author);
        post.setCreatedAt(LocalDateTime.now());

        return postRepository.save(post);
    }

    // 게시글 입력값 검증
    private void validate(PostForm form) {

        if (form.getTitle() == null || form.getTitle().isBlank()
                || form.getContent() == null || form.getContent().isBlank()) {

            throw new IllegalArgumentException(
                "제목과 내용을 모두 입력하세요."
            );
        }

        if (form.getTitle().trim().length() > 100) {

            throw new IllegalArgumentException(
                "제목은 100자까지 입력할 수 있습니다."
            );
        }
    }

    // 게시글 상세 조회
    public Post findById(Long id) {

        return postRepository.findById(id)
            .orElseThrow(() ->
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "글이 존재하지 않습니다."
                )
            );
    }

    // 게시글 수정 화면 (작성자 본인만 접근)
    public Post findForEdit(Long id) {

        Post post = findById(id);

        checkWriter(post);

        return post;
    }

    // 게시글 수정
    public Post edit(Long id, PostForm form) {

        Post post = findForEdit(id);

        validate(form);

        post.setTitle(form.getTitle().trim());
        post.setContent(form.getContent());
        post.setUpdatedAt(LocalDateTime.now());

        return postRepository.save(post);
    }

    // 게시글 삭제 (작성자 또는 관리자)
    public void delete(Long id) {

        Post post = findById(id);

        if (!isAdmin()) {
            checkWriter(post);
        }

        postRepository.delete(post);
    }

    // 작성자 확인
    private void checkWriter(Post post) {

        Authentication auth =
            SecurityContextHolder.getContext().getAuthentication();

        String loginUsername = auth.getName();

        if (!post.getAuthor().getUsername().equals(loginUsername)) {

            throw new AccessDeniedException(
                "본인이 쓴 글만 수정·삭제할 수 있습니다."
            );
        }
    }

    // 관리자 권한 확인
    private boolean isAdmin() {

        Authentication auth =
            SecurityContextHolder.getContext().getAuthentication();

        return auth.getAuthorities().stream()
            .anyMatch(a ->
                a.getAuthority().equals("ROLE_ADMIN")
            );
    }

    // 게시글 페이징 및 검색
    public Page<Post> findPage(String keyword, int page) {

        PageRequest pageable = PageRequest.of(
            Math.max(page, 0),
            PAGE_SIZE,
            Sort.by(Sort.Direction.DESC, "id")
        );

        if (keyword == null || keyword.isBlank()) {

            return postRepository.findAll(pageable);
        }

        return postRepository.search(
            keyword.trim(),
            pageable
        );
    }
}
