
package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.domain.Post;
import com.example.demo.model.dto.PostForm;
import com.example.demo.model.service.CommentService;
import com.example.demo.model.service.PostService;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired // ① 필드 추가 (postService 아래)
    CommentService commentService;

    @Autowired
    private PostService postService;

    // 게시글 목록 및 검색
    // GET /board?page=0&keyword=
    @GetMapping
    public String list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(required = false) String keyword,
            Model model) {

        Page<Post> posts = postService.findPage(keyword, page);

        model.addAttribute("posts", posts.getContent());
        model.addAttribute("page", posts);
        model.addAttribute("keyword", keyword);

        return "board/list";
    }

    // 글쓰기 화면
    @GetMapping("/write")
    public String writeForm(Model model) {

        model.addAttribute("postForm", new PostForm());

        return "board/form";
    }

    // 글쓰기 처리
    @PostMapping("/write")
    public String write(
            @ModelAttribute PostForm postForm,
            Principal principal,
            Model model) {

        try {

            Post post = postService.write(
                    postForm,
                    principal.getName()
            );

            return "redirect:/board/" + post.getId();

        } catch (IllegalArgumentException e) {

            model.addAttribute("error", e.getMessage());
            model.addAttribute("postForm", postForm);

            return "board/form";
        }
    }

    // 게시글 상세 조회
    @GetMapping("/{id}")
    public String detail(
            @PathVariable Long id,
            Model model) {

        Post post = postService.findById(id);

        model.addAttribute("post", post);

        model.addAttribute("comments", commentService.findByPost(post));

        return "board/detail";
    }

    // 게시글 수정 화면
    @GetMapping("/{id}/edit")
    public String editForm(
            @PathVariable Long id,
            Model model) {

        Post post = postService.findForEdit(id);

        PostForm postForm = new PostForm();

        postForm.setTitle(post.getTitle());
        postForm.setContent(post.getContent());

        model.addAttribute("postForm", postForm);
        model.addAttribute("postId", id);

        return "board/form";
    }

    // 게시글 수정 처리
    @PostMapping("/{id}/edit")
    public String edit(
            @PathVariable Long id,
            @ModelAttribute PostForm postForm,
            Model model) {

        try {

            postService.edit(id, postForm);

            return "redirect:/board/" + id;

        } catch (IllegalArgumentException e) {

            model.addAttribute("error", e.getMessage());
            model.addAttribute("postForm", postForm);
            model.addAttribute("postId", id);

            return "board/form";
        }
    }

    // 게시글 삭제
    @PostMapping("/{id}/delete")
    public String delete(
            @PathVariable Long id) {

        postService.delete(id);

        return "redirect:/board?deleted";
    }
}
