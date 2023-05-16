package com.courier.spring.service;

import com.courier.spring.model.Usermodel;
import com.courier.spring.model.Usermodel;

import java.util.List;

public interface UserService {

    Usermodel createUser(Usermodel user);
    Usermodel updateUser(Usermodel user);

    void deleteUser(Usermodel user);
    Usermodel findUserById(Usermodel user);
    Usermodel findUserByEmail(Usermodel user);

    List<Usermodel> userList();
    Usermodel getUser(Usermodel user);

}
