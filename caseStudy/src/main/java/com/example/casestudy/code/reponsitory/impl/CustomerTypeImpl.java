package com.example.casestudy.code.reponsitory.impl;

import com.example.casestudy.code.model.CustomerType;
import com.example.casestudy.code.reponsitory.inter.CustomerTypeInter;
import com.example.casestudy.code.utill.Constraints;
import com.example.casestudy.code.utill.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeImpl implements CustomerTypeInter {
    @Override
    public List<CustomerType> findAll() {
        List<CustomerType>customerTypes=new ArrayList<>();
        try(Connection connection= DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(Constraints.FIND_ALL_CUSTOMERTYPE);) {
            ResultSet resultSet=statement.executeQuery();
            CustomerType customerType;
            while (resultSet.next())
            {
                int id=resultSet.getInt("customer_type_id");
                String name=resultSet.getString("customer_type_name");
                customerType=new CustomerType(id,name);
                customerTypes.add(customerType);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerTypes;
    }

    @Override
    public CustomerType findCustomerTypeById(int id) {
        CustomerType customerType=null;
        try(Connection connection=DatabaseConnection.getConnection();
             PreparedStatement statement=connection.prepareStatement(Constraints.FIND_CUSTOMERTYPE_BY_ID);) {
            statement.setInt(1,id);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next())
            {
                String name=resultSet.getString("customer_type_name");
                customerType=new CustomerType(id,name);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerType;
    }
}
