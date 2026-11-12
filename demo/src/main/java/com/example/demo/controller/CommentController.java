
package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.service.CommentService;

@Controller
@RequestMapping("/board/{postId}/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 댓글 작성
    // POST /board/3/comments
    @PostMapping
    public String write(
            @PathVariable Long postId,
            @RequestParam(defaultValue = "") String content,
            Principal principal) {

        try {

            commentService.write(
                postId,
                content,
                principal.getName()
            );

            return "redirect:/board/" + postId + "#comments";

        } catch (IllegalArgumentException e) {

            // 빈 댓글 또는 500자 초과
            return "redirect:/board/" + postId
                    + "?commentError#comments";
        }
    }

    // 댓글 삭제
    // POST /board/3/comments/7/delete
    @PostMapping("/{id}/delete")
    public String delete(
            @PathVariable Long postId,
            @PathVariable Long id) {

        commentService.delete(id);

        return "redirect:/board/" + postId
                + "?commentDeleted#comments";
    }
}
