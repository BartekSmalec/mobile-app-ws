package com.bartek.mobileappws.services;

import com.bartek.mobileappws.model.User;
import com.bartek.mobileappws.model.UserResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User createUser(UserResponse userResponse) {

        String userId = UUID.randomUUID().toString();

        User user = new User();
        user.setFirstName(userResponse.getFirstName());
        user.setLastName(userResponse.getLastName());
        user.setEmail(userResponse.getEmail());
        user.setUserId(userId);

        return user;
    }
}
