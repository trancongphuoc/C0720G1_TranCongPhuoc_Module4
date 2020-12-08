package com.codegym.service.impl;

import com.codegym.entity.User;
import com.codegym.repository.UserRepository;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByName(String username) {
        return userRepository.findById(username).orElse(null);
    }

    @Override
    public boolean save(User user) {
        if (findByName(user.getUsername()) == null ) {
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }
}
