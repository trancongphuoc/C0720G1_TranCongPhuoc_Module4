package com.codegym.service;

import com.codegym.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(String username);
}
