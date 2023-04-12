package com.bartek.mobileappws.controller;

import com.bartek.mobileappws.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {


    @GetMapping
    public String getUser(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "50") int limit
            , @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
        return "get user was called  page = " + page + " limit = " + limit + " and sort equals " + sort;
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId) {
        User returnedUser = new User();
        returnedUser.setEmail("test@test.com");
        returnedUser.setFirstName("Bartek");
        returnedUser.setLastName("Smalec");

        return returnedUser;
    }

    @PostMapping
    public String createUser() {
        return "create user was called";
    }

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }
}
