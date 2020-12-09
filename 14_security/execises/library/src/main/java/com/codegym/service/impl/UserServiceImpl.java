package com.codegym.service.impl;

import com.codegym.entity.AppUser;
import com.codegym.repository.UserRepository;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;



    @Override
    public List<AppUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public AppUser findByName(String username) {
        return userRepository.findById(username).orElse(null);
    }

    @Override
    public boolean save(AppUser appUser) {
//        if (findByName(appUser.getUsername()) == null ) {
//
//            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//            appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
//            System.out.println(appUser.getPassword());
//            userRepository.save(appUser);
//            return true;
//        } else {
//            return false;
//        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        System.out.println(appUser.getPassword());
        userRepository.save(appUser);
        return true;
    }
}
