package com.codegym.service.user;

import com.codegym.entity.user.User;

public interface UserService {

    User findByUsername(String username);

    void registerNewUser(User user);
}
