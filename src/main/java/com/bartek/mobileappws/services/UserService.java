package com.bartek.mobileappws.services;

import com.bartek.mobileappws.model.User;
import com.bartek.mobileappws.model.UserResponse;

public interface UserService {
    User createUser(UserResponse user);
}
