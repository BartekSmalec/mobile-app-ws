package com.bartek.mobileappws.controller;

import com.bartek.mobileappws.Exceptions.UserServiceException;
import com.bartek.mobileappws.model.UpdateUser;
import com.bartek.mobileappws.model.User;
import com.bartek.mobileappws.model.UserResponse;
import com.bartek.mobileappws.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    Map<String, User> userMap;


    @GetMapping
    public String getUser(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "50") int limit
            , @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
        return "get user was called  page = " + page + " limit = " + limit + " and sort equals " + sort;
    }

    @GetMapping(value = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        User returnedUser = new User();

        String firstName = null;


        if (true) {
            throw new UserServiceException("UserServiceException");
        }

        int firstNameLength = firstName.length();

        if (userMap.containsKey(userId)) return new ResponseEntity<>(userMap.get(userId), HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> createUser(@Valid @RequestBody UserResponse userResponse) {

        User user = userService.createUser(userResponse);


        if (userMap == null) {
            userMap = new HashMap<>();
        }

        userMap.put(user.getUserId(), user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{userId}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public User updateUser(@PathVariable String userId, @RequestBody UpdateUser user) {

        User storedUser = userMap.get(userId);
        storedUser.setFirstName(user.getFirstName());
        storedUser.setLastName(user.getLastName());

        userMap.put(userId, storedUser);

        return storedUser;
    }

    @DeleteMapping(value = "/{userId}")
    public ResponseEntity deleteUser(@PathVariable String userId) {

        userMap.remove(userId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
