package com.example.casestudy.code.reponsitory.inter;

import com.example.casestudy.code.model.User;

import java.util.List;

public interface UserRepoInter {
    void add(User user);
    User findByName(String name);
    List<User> findAll();
}
