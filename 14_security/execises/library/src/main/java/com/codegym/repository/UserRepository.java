package com.codegym.repository;

import com.codegym.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, String> {

    AppUser findByUsername(String username);
}
