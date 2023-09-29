package com.example.casestudy.code.reponsitory.impl;

import com.example.casestudy.code.model.EducationDegree;
import com.example.casestudy.code.reponsitory.inter.EducationDegreeRepoInter;
import com.example.casestudy.code.utill.Constraints;
import com.example.casestudy.code.utill.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepoImple implements EducationDegreeRepoInter {
    @Override
    public EducationDegree findEducationById(int id) {
        EducationDegree educationDegree=null;
        try(Connection connection= DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(Constraints.FIND_ALL_EDUCATION_DEGREE_BY_ID);) {
            statement.setInt(1,id);
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next())
            {
                String name=resultSet.getString("education_degree_name");
                educationDegree=new EducationDegree(id,name);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return educationDegree;
    }

    @Override
    public List<EducationDegree> findALL() {
        List<EducationDegree> educationDegrees=new ArrayList<>();
        try(Connection connection=DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(Constraints.FIND_ALL_EDUCATION_DEGREE);) {
            ResultSet resultSet=statement.executeQuery();
            EducationDegree educationDegree;
            while (resultSet.next())
            {
                int id=resultSet.getInt("education_degree_id");
                String name=resultSet.getString("education_degree_name");
                educationDegree=new EducationDegree(id,name);
                educationDegrees.add(educationDegree);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return educationDegrees;
    }
}
