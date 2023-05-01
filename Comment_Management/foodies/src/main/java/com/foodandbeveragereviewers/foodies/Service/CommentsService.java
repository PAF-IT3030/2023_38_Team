package com.foodandbeveragereviewers.foodies.Service;

import java.util.ArrayList;

import org.attoparser.dom.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.ReturnedType;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.foodandbeveragereviewers.foodies.Entity.Comments;

import com.foodandbeveragereviewers.foodies.Repository.CommentRepo;

@Service
public class CommentsService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    UserService userService;

    public Comments submitCommentToDB(Comments comment) {
        return commentRepo.save(comment);
    }

    public ArrayList<Comments> getAllCommentsForDB(String postId) {

        ArrayList<Comments> commentList = commentRepo.findAllByPostId(postId);

        for (int i = 0; i < commentList.size(); i++) {
            Comments commentItem = commentList.get(i);
            commentItem.setUserName(userService.displayUserMetaData(commentItem.getUserId()).getUserName());
        }

        return commentList;

    }

    public ArrayList<Comments> getAllComments() {

        return commentRepo.findAll();
    }

    public void deleteComment(String commentId) {

        commentRepo.deleteById(commentId);
    }

}
