package com.example.casestudy.code.reponsitory.impl;

import com.example.casestudy.code.model.Position;
import com.example.casestudy.code.reponsitory.inter.PositionRepoInter;
import com.example.casestudy.code.utill.Constraints;
import com.example.casestudy.code.utill.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepoImple implements PositionRepoInter {


    @Override
    public Position findById(int id) {
        Position position=null;
        try(Connection connection= DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(Constraints.FIND_POSITION_BY_ID);){
            statement.setInt(1,id);
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next())
            {
                String name=resultSet.getString("position_name");
                position=new Position(id,name);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return position;
    }

    @Override
    public List<Position> findAll() {
        List<Position>positions=new ArrayList<>();
        try(Connection connection=DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(Constraints.FIND_ALL_POSITION);) {
            ResultSet resultSet=statement.executeQuery();
            Position position;
            while (resultSet.next())
            {
                int id=resultSet.getInt("position_id");
                String name=resultSet.getString("position_name");
                position=new Position(id,name);
                positions.add(position);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return positions;
    }
}
