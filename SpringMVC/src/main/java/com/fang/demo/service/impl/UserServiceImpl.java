package com.fang.demo.service.impl;

import com.fang.demo.model.User;
import com.fang.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> getAllUser() {

        List<User> users = new ArrayList<>();

        users.add(new User("fang", "123"));

        users.add(new User("dandan", "123456"));

        return users;
    }

    @Override
    public User getUserById(int id) {

        if (id == 1) {

        }
        return new User("小强", "456456");
    }
}
