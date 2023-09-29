package jdbc.repository;

import jdbc.model.User;
import jdbc.utill.Constraints;
import jdbc.utill.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserReponsitoryImpl implements UserReponsitory{
    @Override
    public List<User> findAll() {
        List<User>users=new ArrayList<>();
        try(Connection connection=DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(Constraints.FIND_ALL_USER);
            ) {
            ResultSet resultSet=statement.executeQuery();
            User user;
            while (resultSet.next())
            {
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String email=resultSet.getString("email");
                String country=resultSet.getString("country");
                user=new User(id,name,email,country);
                System.out.println(user);
                users.add(user);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public User findByCountry(String country) {
        User user=null;
        try(Connection connection= DatabaseConnection.getConnection();
             PreparedStatement statement=connection.prepareStatement(Constraints.FIND_USER_BY_Country);
             ) {
            statement.setString(1,country);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next())
            {
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String email=resultSet.getString("email");
                user=new User(id,name,email,country);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public User findById(int id) {
        User user=null;
        try(Connection connection= DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(Constraints.FIND_USER_BY_ID);
        ) {
            statement.setInt(1,id);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next())
            {
                String name=resultSet.getString("name");
                String email=resultSet.getString("email");
                String country=resultSet.getString("country");
                user=new User(id,name,email,country);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public void add(User user) {
        try(Connection connection=DatabaseConnection.getConnection();
             PreparedStatement statement=connection.prepareStatement(Constraints.CREATE_USER);) {
            statement.setString(1,user.getName());
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getCountry());
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try(Connection connection=DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(Constraints.DELETE_USER_BY_ID);) {
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {
        try(Connection connection=DatabaseConnection.getConnection();
             PreparedStatement statement=connection.prepareStatement(Constraints.UPDATE_USER);) {
            statement.setInt(4,user.getId());
            statement.setString(1,user.getName());
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getCountry());
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
