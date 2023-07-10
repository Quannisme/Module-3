package jdbc.service;

import jdbc.model.User;
import jdbc.repository.UserReponsitory;
import jdbc.repository.UserReponsitoryImpl;

import java.util.List;

public class UserServiceImpl implements UserService{
    UserReponsitory userReponsitory=new UserReponsitoryImpl();
    @Override
    public void add(User user) {
        userReponsitory.add(user);
    }

    @Override
    public void delete(int id) {
        userReponsitory.delete(id);
    }

    @Override
    public User findByCountry(String country) {
        return userReponsitory.findByCountry(country);
    }

    @Override
    public User findById(int id) {
        return userReponsitory.findById(id);
    }

    @Override
    public void update(User user) {
        userReponsitory.update(user);
    }

    @Override
    public List<User> findAll() {
        return userReponsitory.findAll();
    }
}
