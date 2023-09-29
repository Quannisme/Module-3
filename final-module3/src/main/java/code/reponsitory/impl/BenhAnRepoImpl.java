package code.reponsitory.impl;

import code.model.BenhAn;
import code.reponsitory.inter.BenhAnRepoInter;
import code.util.Constrain;
import code.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhAnRepoImpl implements BenhAnRepoInter {

    @Override
    public List<BenhAn> findAll() {
        List<BenhAn>benhAns=new ArrayList<>();
        try(Connection connection= DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(Constrain.FIND_ALL_BENH_AN);) {
            ResultSet resultSet=statement.executeQuery();
            BenhAn benhAnn;
            while (resultSet.next())
            {
                String id=resultSet.getString("id_benh_an");
                String name=resultSet.getString("name_benh_an");
                benhAnn=new BenhAn(id,name);
                benhAns.add(benhAnn);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return benhAns;
    }

    @Override
    public BenhAn findBenhAnById(String id) {
        BenhAn benhAn=null;
        try(Connection connection= DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(Constrain.FIND_BENH_AN_BY_ID);) {
            statement.setString(1,id);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next())
            {
                String name=resultSet.getString("name_benh_an");
                benhAn=new BenhAn(id,name);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return benhAn;
    }
}
