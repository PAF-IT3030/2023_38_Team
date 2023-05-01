package com.technicalinterview.instagramclone.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalinterview.instagramclone.Entity.Post;
import com.technicalinterview.instagramclone.Entity.Status;
import com.technicalinterview.instagramclone.Repository.PostRepo;


@Service
public class PostService {

	@Autowired
	PostRepo postRepo;
	
	@Autowired
	UserService userService;
	
	public Post submitPostToDataBase(Post post) {
		return postRepo.save(post);
	}
	
	public ArrayList<Post> retrivePostFromDB(){

		ArrayList<Post> postList=postRepo.findAll();
		
		for(int i=0;i<postList.size();i++) {
			Post postItem=postList.get(i);
			postItem.setUserName(userService.displayUserMetaData(postItem.getUserId()).getUserName());
		}
		Collections.sort(postList,(a,b)->b.getId()-a.getId());
		return postList;
	}

	public ArrayList<Post> deletePostFromDB(int Id){
		postRepo.deleteById(Id);
		
		ArrayList<Post> result=retrivePostFromDB();
		return result;
	}

	public void updatePost(int Id, Post updatedPost) {
        try {
            Post post = postRepo.findById(Id).orElseThrow(() -> new RuntimeException("Post not found with ID " + Id));
            post.setPostPath(updatedPost.getPostPath());
            post.setLikeCount(updatedPost.getLikeCount());
            // Update any other fields as needed
            postRepo.save(post);
        } catch (Exception e) {
            // Handle any exceptions that may occur during the update process
            throw new RuntimeException("Failed to update post with ID " + Id, e);
        }
    }



    



	
	
}
