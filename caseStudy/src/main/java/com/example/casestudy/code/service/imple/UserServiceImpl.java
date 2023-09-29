package com.example.casestudy.code.service.imple;

import com.example.casestudy.code.model.User;
import com.example.casestudy.code.reponsitory.impl.UserRepoImple;
import com.example.casestudy.code.reponsitory.inter.UserRepoInter;
import com.example.casestudy.code.service.inter.UserServiceInter;

import java.util.List;

public class UserServiceImpl implements UserServiceInter {
    UserRepoInter userRepo=new UserRepoImple();
    @Override
    public void add(User user) {
        userRepo.add(user);
    }

    @Override
    public User findByName(String name) {
        return userRepo.findByName(name);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }
}
