package com.codegym.service;

import com.codegym.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findByName(String username);

    boolean save(User user);
}
