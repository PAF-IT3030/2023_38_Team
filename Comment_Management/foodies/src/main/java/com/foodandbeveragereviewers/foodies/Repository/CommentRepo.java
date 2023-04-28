package com.foodandbeveragereviewers.foodies.Repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.foodandbeveragereviewers.foodies.Entity.Comments;

@Repository
public interface CommentRepo extends CrudRepository<Comments, Integer> {

    Comments save(Comments comment);

    ArrayList<Comments> findAllByPostId(String postId);

    ArrayList<Comments> findAll();
}
