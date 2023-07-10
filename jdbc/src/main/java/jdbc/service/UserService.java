package jdbc.service;

import jdbc.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void delete(int id);
    User findByCountry(String country);
    User findById(int id);
    void update(User user);
    List<User> findAll();
}
