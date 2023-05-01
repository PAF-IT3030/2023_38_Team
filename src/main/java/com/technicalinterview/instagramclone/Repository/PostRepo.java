package com.technicalinterview.instagramclone.Repository;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.technicalinterview.instagramclone.Entity.Post;


@Repository
public interface PostRepo extends CrudRepository<Post, Integer> {

	Post save(Post post);
	ArrayList<Post> findAll();
	void deleteById(int Id);
		default void updatePost(Post post) {
			save(post);
		}
	
	
	
	
}
