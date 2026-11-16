
package com.example.demo.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.domain.Member;
import com.example.demo.model.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    // 제목 또는 내용으로 게시글 검색
    @Query("SELECT p FROM Post p WHERE p.title LIKE %:keyword% OR p.content LIKE %:keyword%")
    Page<Post> search(
        @Param("keyword") String keyword,
        Pageable pageable
    );

    // 특정 회원이 작성한 게시글이 있는지 확인
    boolean existsByAuthor(Member author);

    // 특정 회원이 작성한 게시글을 최신순으로 조회
    Page<Post> findByAuthor_UsernameOrderByIdDesc(
        String username,
        Pageable pageable
    );
}
