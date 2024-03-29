package com.example.user_role.repo;

import com.example.user_role.model.Role;
import com.example.user_role.model.User;
import com.example.user_role.model.UserRole;
import com.example.user_role.util.Constants;
import com.example.user_role.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRoleRepoImpl implements UserRoleRepoI {

    @Override
    public List<UserRole> findAll() {
        List<UserRole> userRoles = new ArrayList<>();
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constants.FIND_ALL_USER_ROLE)
        ) {
            ResultSet resultSet = statement.executeQuery();
            User user;
            while (resultSet.next()) {
                int idUser = resultSet.getInt("id_user");
                String fullName = resultSet.getString("full_Name");
                String code = resultSet.getString("code");
                String birth = resultSet.getString("birth");
                String startDate = resultSet.getString("start_date");
                Role role = new Role();
                role.setRoleName(resultSet.getString("role_name"));
                user = new User(idUser, fullName, code, birth, startDate, null);
                userRoles.add(new UserRole(user, role));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return userRoles;
    }

    @Override
    public UserRole findById(int id) {
        UserRole userRole = null;
        PreparedStatement statement =null;
        try {
            Connection connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(Constants.FIND_BY_ID_USER);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            User user;
            while (resultSet.next()){
                String fullName = resultSet.getString("full_Name");
                String code = resultSet.getString("code");
                String birth = resultSet.getString("birth");
                String startDate = resultSet.getString("start_date");
                Role role = new Role();
                role.setRoleName(resultSet.getString("role_name"));
                user = new User(id, fullName, code, birth, startDate, null);
                userRole = new UserRole(user,role);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return userRole;
    }

    @Override
    public boolean add(User user) throws SQLException {
        PreparedStatement statement = null;
        try (Connection connection = DatabaseConnection.getConnection();
        ) {

            statement = connection.prepareStatement(Constants.ADD_USER);
            //insert user
            statement.setInt(1, user.getIdUser());
            statement.setString(2, user.getFullName());
            statement.setString(3, user.getCode());
            statement.setString(4, user.getBirth());
            statement.setString(5, user.getStartDate());
            statement.executeUpdate();
            //insert role
            for (Role role : user.getRoles()) {
                statement = connection.prepareStatement(Constants.ADD_USER_ROLE);
                statement.setInt(1, user.getIdUser());
                statement.setInt(2, role.getIdRole());
                statement.executeUpdate();
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            statement.close();
        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        PreparedStatement statement = null;
        try (Connection connection = DatabaseConnection.getConnection();
        ) {
            statement = connection.prepareStatement(Constants.DELETE_USER_ROLE);
            statement.setInt(1, id);
            statement.executeUpdate();

            statement = connection.prepareStatement(Constants.DELETE_USER);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean update(UserRole userRole) throws SQLException {
        PreparedStatement statement = null;
        try (Connection connection = DatabaseConnection.getConnection();
        ) {
           statement = connection.prepareStatement(Constants.UPDATE_User_Role);
           statement.setString(1, userRole.getUser().getFullName());
           statement.setString(2, userRole.getUser().getCode());
           statement.setString(3, userRole.getUser().getBirth());
           statement.setString(4, userRole.getUser().getStartDate());
           statement.setInt(5, userRole.getUser().getIdUser());
           statement.executeUpdate();
           for(Role role: userRole.getUser().getRoles()) {
               statement.setInt(1,role.getIdRole());
               statement.setInt(2, userRole.getUser().getIdUser());
               statement.setInt(3,role.getIdRole());
               statement.executeUpdate();
           }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

}
