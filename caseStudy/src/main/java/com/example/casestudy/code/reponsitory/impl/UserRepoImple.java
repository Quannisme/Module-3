package com.example.casestudy.code.reponsitory.impl;

import com.example.casestudy.code.model.User;
import com.example.casestudy.code.reponsitory.inter.UserRepoInter;
import com.example.casestudy.code.utill.Constraints;
import com.example.casestudy.code.utill.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepoImple implements UserRepoInter {
    @Override
    public void add(User user) {
        try ( Connection connection=DatabaseConnection.getConnection();
               PreparedStatement statement=connection.prepareStatement(Constraints.CREATE_USER);){
            statement.setString(1,user.getName());
            statement.setString(2,user.getPassword());
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findByName(String name) {
        User user=null;
        try(Connection connection= DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(Constraints.FIND_USER_BY_NAME);) {
            statement.setString(1,name);
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next())
            {
                String password=resultSet.getString("password");
                user=new User(name,password);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User>users=new ArrayList<>();
        try(Connection connection=DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(Constraints.FIND_ALL_USER);) {
            ResultSet resultSet=statement.executeQuery();
            User user;
            while (resultSet.next())
            {
                String name=resultSet.getString("username");
                String password=resultSet.getString("password");
                user=new User(name,password);
                users.add(user);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
