package com.foodandbeveragereviewers.foodies.Controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.foodandbeveragereviewers.foodies.Entity.Comments;
import com.foodandbeveragereviewers.foodies.Repository.CommentRepo;
import com.foodandbeveragereviewers.foodies.Service.CommentsService;

@CrossOrigin
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentsService commentsService;

    @Autowired
    CommentRepo commentRepo;

    @PostMapping("/add")
    private Comments submitComment(@RequestBody Comments comment) {
        return commentsService.submitCommentToDB(comment);
    }

    @GetMapping("/getAll")
    private ArrayList<Comments> getAllComments() {
        return commentsService.getAllComments();
    }

    @GetMapping("/{postId}")
    private ArrayList<Comments> getCommentsForPost(@PathVariable("postId") String postId) {
        return commentsService.getAllCommentsForDB(postId);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        Optional<Comments> comment = commentRepo.findById(id);
        if (comment.isPresent()) {
            commentRepo.delete(comment.get());
            return "Comment deleted for the id" + id;
        } else {
            throw new RuntimeException("Comment not found for the id " + id);
        }
    }

    @PutMapping("/update/{id}")
    public Comments update(@RequestBody Comments commentObj) {
        return commentRepo.save(commentObj);
    }

}
