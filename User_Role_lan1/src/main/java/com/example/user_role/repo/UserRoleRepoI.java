package com.example.user_role.repo;

import com.example.user_role.model.User;
import com.example.user_role.model.UserRole;

import java.sql.SQLException;
import java.util.List;

public interface UserRoleRepoI  {
    List<UserRole> findAll();
    UserRole findById(int id);
    boolean add (User user) throws SQLException;
    boolean remove(int id) throws SQLException;
    boolean update(UserRole userRole) throws  SQLException;
}
