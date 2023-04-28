package com.foodandbeveragereviewers.foodies.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodandbeveragereviewers.foodies.Entity.Users;
import com.foodandbeveragereviewers.foodies.Repository.UserRepo;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public Users submitMetaDataOfUser(Users user) {
        return userRepo.save(user);
    }

    public Users displayUserMetaData(String userid) {
        return userRepo.findByUserId(userid);
    }
}
