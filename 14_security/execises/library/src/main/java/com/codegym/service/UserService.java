package com.codegym.service;

import com.codegym.entity.AppUser;

import java.util.List;

public interface UserService {

    List<AppUser> findAll();

    AppUser findByName(String username);

    boolean save(AppUser appUser);
}
