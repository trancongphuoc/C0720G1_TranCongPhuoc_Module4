package com.codegym.service;

import com.codegym.model.Login;
import com.codegym.model.User;

public interface UserService {

    User checkLogin(Login login);

}
