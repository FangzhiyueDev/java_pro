package com.fang.demo.service;

import com.fang.demo.model.User;

import java.util.List;

public interface UserService {


    List<User> getAllUser();

    User getUserById(int id);

}
