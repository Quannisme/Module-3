package jdbc.repository;

import jdbc.model.User;

import java.util.List;

public interface UserReponsitory {
    List<User> findAll();
    User findByCountry(String country);
    User findById(int id);
    void add(User user);
    void delete(int id);
    void update(User user);
}
