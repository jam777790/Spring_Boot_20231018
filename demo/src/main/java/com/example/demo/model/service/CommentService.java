
package com.example.demo.model.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.domain.Comment;
import com.example.demo.model.domain.Member;
import com.example.demo.model.domain.Post;
import com.example.demo.model.repository.CommentRepository;
import com.example.demo.model.repository.MemberRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PostService postService;

    // 해당 게시글의 댓글 목록 조회
    public List<Comment> findByPost(Post post) {

        return commentRepository.findByPostOrderByIdAsc(post);
    }

    // 댓글 작성
    public Comment write(Long postId, String content, String username) {

        if (content == null || content.isBlank() || content.length() > 500) {

            throw new IllegalArgumentException(
                "댓글은 1~500자로 입력하세요."
            );
        }

        // 게시글 조회
        Post post = postService.findById(postId);

        // 작성자 조회
        Member author = memberRepository.findByUsername(username)
            .orElseThrow(() ->
                new IllegalArgumentException("회원이 존재하지 않습니다.")
            );

        Comment comment = new Comment();

        comment.setContent(content.trim());
        comment.setPost(post);
        comment.setAuthor(author);
        comment.setCreatedAt(LocalDateTime.now());

        return commentRepository.save(comment);
    }

    // 댓글 삭제 (본인 또는 관리자)
    public void delete(Long id) {

        Comment comment = commentRepository.findById(id)
            .orElseThrow(() ->
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "댓글이 존재하지 않습니다."
                )
            );

        // 관리자가 아니면 작성자 확인
        if (!isAdmin()) {
            checkWriter(comment);
        }

        commentRepository.delete(comment);
    }

    // 댓글 작성자 확인
    private void checkWriter(Comment comment) {

        String loginUsername =
            SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        if (!comment.getAuthor().getUsername().equals(loginUsername)) {

            throw new AccessDeniedException(
                "본인이 쓴 댓글만 삭제할 수 있습니다."
            );
        }
    }

    // 관리자 권한 확인
    private boolean isAdmin() {

        Authentication auth =
            SecurityContextHolder.getContext()
                .getAuthentication();

        return auth.getAuthorities().stream()
            .anyMatch(a ->
                a.getAuthority().equals("ROLE_ADMIN")
            );
    }
}
