package com.example.casestudy.code.reponsitory.impl;

import com.example.casestudy.code.model.Division;
import com.example.casestudy.code.reponsitory.inter.DivisionRepoInter;
import com.example.casestudy.code.utill.Constraints;
import com.example.casestudy.code.utill.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepoImple implements DivisionRepoInter {
    @Override
    public Division findById(int id) {
        Division division=null;
        try(Connection connection=DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(Constraints.FIND_DIVISION_BYID);){
            statement.setInt(1,id);
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next())
            {
                String name=resultSet.getString("division_name");
                division=new Division(id,name);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return division;
    }

    @Override
    public List<Division> FindALL() {
        List<Division> divisions=new ArrayList<>();
        try(Connection connection=DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(Constraints.FIND_ALL_DIVISION);) {
            ResultSet resultSet=statement.executeQuery();
            Division division;
            while (resultSet.next())
            {
                int id=resultSet.getInt("division_id");
                String name=resultSet.getString("division_name");
                division =new Division(id,name);
                divisions.add(division);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return divisions;
    }
}
