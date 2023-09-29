package code.reponsitory.impl;

import code.model.BenhAn;
import code.model.BenhNhan;
import code.reponsitory.inter.BenhAnRepoInter;
import code.reponsitory.inter.BenhNhanRepoInter;
import code.util.Constrain;
import code.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhNhanRepoImpl implements BenhNhanRepoInter {
    private BenhAnRepoInter benhAnRepoInter=new BenhAnRepoImpl();
    @Override
    public void add(BenhNhan benhNhan) {
        try (Connection connection= DatabaseConnection.getConnection();
             PreparedStatement statement=connection.prepareStatement(Constrain.CREATE_BENH_NHAN);){
            statement.setString(1,benhNhan.getId());
            statement.setString(2,benhNhan.getName());
            statement.setDate(3, new java.sql.Date(benhNhan.getIn().getTime()));
            statement.setDate(4, new java.sql.Date(benhNhan.getOut().getTime()));
            statement.setString(5,benhNhan.getLyDo());
            statement.setString(6,benhNhan.getBenhAn().getId());
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<BenhNhan> FindAll() {
        List<BenhNhan> benhNhans=new ArrayList<>();
        try(Connection connection= DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(Constrain.FIND_ALL_BENH_NHAN);) {
            ResultSet resultSet=statement.executeQuery();
            BenhNhan benhNhan;
            while (resultSet.next())
            {
                String id=resultSet.getString("id_benh_nhan");
                String name=resultSet.getString("name_benh_nhan");
                java.util.Date in=new java.util.Date(resultSet.getDate("ngay_nhap_vien").getTime());
                java.util.Date out=new java.util.Date(resultSet.getDate("ngay_ra_vien").getTime());
                String lyDo=resultSet.getString("ly_do");
                String benhAnid=resultSet.getString("id_benh_an");
                BenhAn benhAn=benhAnRepoInter.findBenhAnById(benhAnid);
                benhNhan=new BenhNhan(id,name,in,out,lyDo,benhAn);
                benhNhans.add(benhNhan);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return benhNhans;
    }

    @Override
    public void delete(String id) {
        try(Connection connection= DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(Constrain.DELETE_BENH_NHAN_BY_ID);) {
            statement.setString(1,id);
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(BenhNhan benhNhan) {
        try(Connection connection=DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(Constrain.EDIT_BENH_NHAN);) {
            statement.setString(6,benhNhan.getId());
            statement.setString(1,benhNhan.getName());
            statement.setDate(2, new java.sql.Date(benhNhan.getIn().getTime()));
            statement.setDate(3, new java.sql.Date(benhNhan.getOut().getTime()));
            statement.setString(4,benhNhan.getLyDo());
            statement.setString(5,benhNhan.getBenhAn().getId());
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BenhNhan findById(String id) {
        BenhNhan benhNhan=null;
        try(Connection connection= DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(Constrain.FIND_BENH_NHAN_BY_ID);) {
            statement.setString(1,id);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next())
            {
                String name=resultSet.getString("name_benh_nhan");
                java.util.Date in=new java.util.Date(resultSet.getDate("ngay_nhap_vien").getTime());
                java.util.Date out=new java.util.Date(resultSet.getDate("ngay_ra_vien").getTime());
                String lyDo=resultSet.getString("ly_do");
                String benhAnid=resultSet.getString("id_benh_an");
                BenhAn benhAn=benhAnRepoInter.findBenhAnById(benhAnid);
                benhNhan=new BenhNhan(id,name,in,out,lyDo,benhAn);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return benhNhan;
    }
}
