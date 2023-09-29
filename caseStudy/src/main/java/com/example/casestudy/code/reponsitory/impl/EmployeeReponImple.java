package com.example.casestudy.code.reponsitory.impl;

import com.example.casestudy.code.model.*;
import com.example.casestudy.code.reponsitory.inter.*;
import com.example.casestudy.code.utill.Constraints;
import com.example.casestudy.code.utill.DatabaseConnection;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeReponImple implements EmployeeRepoInter {
    private DivisionRepoInter divisionRepoInter=new DivisionRepoImple();
    private EducationDegreeRepoInter educationDegreeRepoInter=new EducationDegreeRepoImple();
    private PositionRepoInter positionRepoInter=new PositionRepoImple();
    private UserRepoInter userRepoInter=new UserRepoImple();
    @Override
    public void add(Employee employee) {
        try (Connection connection= DatabaseConnection.getConnection();
             PreparedStatement statement=connection.prepareStatement(Constraints.CREATE_EMPLOYEE);){
            statement.setString(1,employee.getId());
            statement.setString(2,employee.getName());
            statement.setDate(3, new java.sql.Date(employee.getBirthDay().getTime()));
            statement.setString(4,employee.getIdCard());
            statement.setDouble(5,employee.getSalary());
            statement.setString(6,employee.getPhone());
            statement.setString(7,employee.getEmail());
            statement.setString(8,employee.getAddress());
            statement.setInt(9,employee.getPosition().getId());
            statement.setInt(10,employee.getEducationDegree().getId());
            statement.setInt(11,employee.getDivision().getId());
            statement.setString(12,employee.getUser().getName());
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> FindAll() {
        List<Employee> employees=new ArrayList<>();
        try(Connection connection=DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(Constraints.FIND_ALL_EMPLOYEE);) {
            ResultSet resultSet=statement.executeQuery();
            Employee employee;
            while (resultSet.next())
            {
                String id=resultSet.getString("employee_id");
                String name=resultSet.getString("employee_name");
                java.util.Date birthDate=new java.util.Date(resultSet.getDate("employee_birthday").getTime());
                String idCard=resultSet.getString("employee_id_card");
                double salary=resultSet.getDouble("employee_salary");
                String phone=resultSet.getString("employee_phone");
                String email=resultSet.getString("employee_email");
                String adress=resultSet.getString("employee_address");
                int positionId=resultSet.getInt("position_id");
                Position position=positionRepoInter.findById(positionId);
                int educationDegreeId=resultSet.getInt("education_degree_id");
                EducationDegree educationDegree=educationDegreeRepoInter.findEducationById(educationDegreeId);
                int divisionId=resultSet.getInt("division_id");
                Division division=divisionRepoInter.findById(divisionId);
                String userName=resultSet.getString("username");
                User user=userRepoInter.findByName(userName);
                employee=new Employee(id,name,birthDate,idCard,salary,phone,email,adress,position,educationDegree,division,user);
                employees.add(employee);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    @Override
    public void delete(String id) {
        try(Connection connection=DatabaseConnection.getConnection();
             PreparedStatement statement=connection.prepareStatement(Constraints.DELETE_EMPLOYEE_BY_ID);) {
            statement.setString(1,id);
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Employee employee) {
        try(Connection connection=DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(Constraints.EDIT_EMPLOYEE);) {
            statement.setString(12,employee.getId());
            statement.setString(1,employee.getName());
            statement.setDate(2, new java.sql.Date(employee.getBirthDay().getTime()));
            statement.setString(3,employee.getIdCard());
            statement.setDouble(4,employee.getSalary());
            statement.setString(5,employee.getPhone());
            statement.setString(6,employee.getEmail());
            statement.setString(7,employee.getAddress());
            statement.setInt(8,employee.getPosition().getId());
            statement.setInt(9,employee.getEducationDegree().getId());
            statement.setInt(10,employee.getDivision().getId());
            statement.setString(11,employee.getUser().getName());
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Employee findById(String id) {
        Employee employee=null;
        try(Connection connection=DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(Constraints.FIND_EMPLOYEE_BY_ID);) {
            statement.setString(1,id);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next())
            {
                String name=resultSet.getString("employee_name");
                java.util.Date birthDate=new java.util.Date(resultSet.getDate("employee_birthday").getTime());
                String idCard=resultSet.getString("employee_id_card");
                double salary=resultSet.getDouble("employee_salary");
                String phone=resultSet.getString("employee_phone");
                String email=resultSet.getString("employee_email");
                String adress=resultSet.getString("employee_address");
                int positionId=resultSet.getInt("position_id");
                Position position=positionRepoInter.findById(positionId);
                int educationDegreeId=resultSet.getInt("education_degree_id");
                EducationDegree educationDegree=educationDegreeRepoInter.findEducationById(educationDegreeId);
                int divisionId=resultSet.getInt("division_id");
                Division division=divisionRepoInter.findById(divisionId);
                String userName=resultSet.getString("username");
                User user=userRepoInter.findByName(userName);
                employee=new Employee(id,name,birthDate,idCard,salary,phone,email,adress,position,educationDegree,division,user);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    @Override
    public Employee findByName(String name) {
        Employee employee=null;
        try (Connection connection=DatabaseConnection.getConnection();
              PreparedStatement statement=connection.prepareStatement(Constraints.FIND_EMPLOYEE_BY_NAME);){
            statement.setString(1,name);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next())
            {
                String id=resultSet.getString("employee_id");
                java.util.Date birthDate=new java.util.Date(resultSet.getDate("employee_birthday").getTime());
                String idCard=resultSet.getString("employee_id_card");
                double salary=resultSet.getDouble("employee_salary");
                String phone=resultSet.getString("employee_phone");
                String email=resultSet.getString("employee_email");
                String adress=resultSet.getString("employee_address");
                int positionId=resultSet.getInt("position_id");
                Position position=positionRepoInter.findById(positionId);
                int educationDegreeId=resultSet.getInt("education_degree_id");
                EducationDegree educationDegree=educationDegreeRepoInter.findEducationById(educationDegreeId);
                int divisionId=resultSet.getInt("division_id");
                Division division=divisionRepoInter.findById(divisionId);
                String userName=resultSet.getString("username");
                User user=userRepoInter.findByName(userName);
                employee=new Employee(id,name,birthDate,idCard,salary,phone,email,adress,position,educationDegree,division,user);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    @Override
    public List<Employee> showBy(String id, String name, String idcard) {
        List<Employee> employees = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            Connection connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(Constraints.FIND_ALL_BY_ALL);
            statement.setString(1, "%" + name + "%");
            statement.setString(2, "%" + id + "%");
            statement.setString(3, "%" + idcard + "%");
            ResultSet resultSet = statement.executeQuery();
            Employee employee;
            while (resultSet.next()) {
                id= resultSet.getString("employee_id");
                name = resultSet.getString("employee_name");
                java.util.Date birthDate=new java.util.Date(resultSet.getDate("employee_birthday").getTime());
                idcard=resultSet.getString("employee_id_card");
                double salary=resultSet.getDouble("employee_salary");
                String phone=resultSet.getString("employee_phone");
                String email=resultSet.getString("employee_email");
                String adress=resultSet.getString("employee_address");
                int positionId=resultSet.getInt("position_id");
                Position position=positionRepoInter.findById(positionId);
                int educationDegreeId=resultSet.getInt("education_degree_id");
                EducationDegree educationDegree=educationDegreeRepoInter.findEducationById(educationDegreeId);
                int divisionId=resultSet.getInt("division_id");
                Division division=divisionRepoInter.findById(divisionId);
                String userName=resultSet.getString("username");
                User user=userRepoInter.findByName(userName);
                employee=new Employee(id,name,birthDate,idcard,salary,phone,email,adress,position,educationDegree,division,user);
                employees.add(employee);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return employees;
    }
}
