package com.technicalinterview.instagramclone.Controller;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.technicalinterview.instagramclone.Entity.Post;
import com.technicalinterview.instagramclone.Service.PostService;


@CrossOrigin
@RestController
@RequestMapping("/pst")
public class PostController {

	@Autowired
	PostService postService;
	
	@PostMapping("")
	private Post submitUserPost(@RequestBody Post post) {
		return postService.submitPostToDataBase(post);
	}
	
	@GetMapping("")
	private ArrayList<Post> getAllPost(){
		return postService.retrivePostFromDB();
	}
	@DeleteMapping("/{Id}")
	public ArrayList<Post> deleteParticularPost(@PathVariable("Id") int Id){
		ArrayList<Post> result=postService.deletePostFromDB(Id);
		return result;
	}

	@PutMapping("/{Id}")
  public ResponseEntity<?> updatePost(@PathVariable int Id, @RequestBody Post updatedPost) {
    try {
        postService.updatePost(Id, updatedPost);
        return ResponseEntity.ok().build();
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

	

	
	

	




	



	


}
