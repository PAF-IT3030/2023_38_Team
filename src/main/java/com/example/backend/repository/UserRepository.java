package com.example.backend.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.technicalinterview.instagramclone.Entity.Users;
public class UserRepository extends CrudRepository<Users, Integer> {
    Users save(Users user);
	Users findByUserId(String userId);
}

    

