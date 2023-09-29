package com.example.casestudy.code.service.inter;

import com.example.casestudy.code.model.User;

import java.util.List;

public interface UserServiceInter {
    void add(User user);
    User findByName(String name);
    List<User> findAll();
}
