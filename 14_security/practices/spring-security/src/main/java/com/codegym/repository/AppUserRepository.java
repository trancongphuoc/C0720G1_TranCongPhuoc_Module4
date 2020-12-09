package com.codegym.repository;

import com.codegym.entity.AppUser;
import com.codegym.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUserName(String userName);
}
