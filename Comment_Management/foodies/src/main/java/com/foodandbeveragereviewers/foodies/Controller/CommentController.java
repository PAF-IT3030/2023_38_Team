package com.foodandbeveragereviewers.foodies.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodandbeveragereviewers.foodies.Entity.Comments;
import com.foodandbeveragereviewers.foodies.Service.CommentsService;

@CrossOrigin
@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    CommentsService commentsService;

    @PostMapping("")
    private Comments submitComment(@RequestBody Comments comment) {
        return commentsService.submitCommentToDB(comment);
    }

    @GetMapping("/{postId}")
    private ArrayList<Comments> getCommentsForPost(@PathVariable("postId") String postId) {
        return commentsService.getAllCommentsForDB(postId);
    }

    @GetMapping("")
    private ArrayList<Comments> getAllComments() {
        return commentsService.getAllComments();
    }

    @DeleteMapping("/delete/{commentId}")
    public void deleteComment(@PathVariable String commentId) {
        commentsService.deleteComment(commentId);
    }
}
