package com.foodandbeveragereviewers.foodies.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodandbeveragereviewers.foodies.Entity.Users;

@RestController
@RequestMapping("/users")
public class UserContoller {

    @PostMapping("")
    private boolean submitUser() {
        return true;
    }

    @GetMapping("/{userId}")
    private Users getUserDetails(@PathVariable("userId") String UserId) {

        return new Users();
    }
}
