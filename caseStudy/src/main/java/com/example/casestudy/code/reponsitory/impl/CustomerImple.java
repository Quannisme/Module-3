package com.example.casestudy.code.reponsitory.impl;

import com.example.casestudy.code.model.Customer;
import com.example.casestudy.code.model.CustomerType;
import com.example.casestudy.code.reponsitory.inter.CustomerInter;
import com.example.casestudy.code.reponsitory.inter.CustomerTypeInter;
import com.example.casestudy.code.utill.Constraints;
import com.example.casestudy.code.utill.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerImple implements CustomerInter {
    private CustomerTypeInter customerTypeInter=new CustomerTypeImpl();
    @Override
    public void deleteById(String id) {
        try (Connection connection=DatabaseConnection.getConnection();
             PreparedStatement statement=connection.prepareStatement(Constraints.DELETE_CUSTOMER_BY_ID);){
            statement.setString(1,id);
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(Customer customer) {
        try (Connection connection=DatabaseConnection.getConnection();
             PreparedStatement statement=connection.prepareStatement(Constraints.EDIT_CUSTOMER);){
            statement.setString(9,customer.getId());
            statement.setInt(1,customer.getCustomerType().getId());
            statement.setString(2,customer.getName());
            statement.setDate(3,new java.sql.Date(customer.getBirthDay().getTime()));
            statement.setBoolean(4,customer.isGender());
            statement.setString(5,customer.getIdCard());
            statement.setString(6,customer.getPhone());
            statement.setString(7,customer.getEmail());
            statement.setString(8,customer.getAddress());
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Customer customer) {
        try(Connection connection=DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(Constraints.CREATE_CUSTOMER);) {
            statement.setString(1,customer.getId());
            statement.setInt(2,customer.getCustomerType().getId());
            statement.setString(3,customer.getName());
            statement.setDate(4,new java.sql.Date(customer.getBirthDay().getTime()));
            statement.setBoolean(5,customer.isGender());
            statement.setString(6,customer.getIdCard());
            statement.setString(7,customer.getPhone());
            statement.setString(8,customer.getEmail());
            statement.setString(9,customer.getAddress());
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> findAll() {
        List<Customer>customers=new ArrayList<>();
        try(Connection connection= DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(Constraints.FIND_ALL_CUSTOMER);) {
            ResultSet resultSet=statement.executeQuery();
            Customer customer;
            while (resultSet.next())
            {
                String id=resultSet.getString("customer_id");
                int customerTypeId=resultSet.getInt("customer_type_id");
                CustomerType customerType=customerTypeInter.findCustomerTypeById(customerTypeId);
                String name=resultSet.getString("customer_name");
                Date birthDay=new Date(resultSet.getDate("customer_birthday").getTime());
                boolean gender=resultSet.getBoolean("customer_gender");
                String idCard=resultSet.getString("customer_id_card");
                String phone=resultSet.getString("customer_phone");
                String email=resultSet.getString("customer_email");
                String adress=resultSet.getString("customer_address");
                customer=new Customer(id,customerType,name,birthDay,gender,idCard,phone,email,adress);
                customers.add(customer);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    @Override
    public Customer findById(String id) {
        Customer customer=null;
        try (Connection connection=DatabaseConnection.getConnection();
             PreparedStatement statement=connection.prepareStatement(Constraints.FIND_CUSTOMER_BY_ID)){
            statement.setString(1,id);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next())
            {
                int customerTypeId=resultSet.getInt("customer_type_id");
                CustomerType customerType=customerTypeInter.findCustomerTypeById(customerTypeId);
                String name=resultSet.getString("customer_name");
                Date birthDay=new Date(resultSet.getDate("customer_birthday").getTime());
                boolean gender=resultSet.getBoolean("customer_gender");
                String idCard=resultSet.getString("customer_id_card");
                String phone=resultSet.getString("customer_phone");
                String email=resultSet.getString("customer_email");
                String adress=resultSet.getString("customer_address");
                customer=new Customer(id,customerType,name,birthDay,gender,idCard,phone,email,adress);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }
}
