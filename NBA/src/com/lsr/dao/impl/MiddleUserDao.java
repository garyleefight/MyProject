package com.lsr.dao.impl;

import com.lsr.dao.IMiddleUser;
import com.lsr.entity.Rela_user;
import com.lsr.util.Jdbc_util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lsr on 16/10/8.
 */
public class MiddleUserDao implements IMiddleUser{
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    @Override
    public void save(Rela_user rela_user) {
        String sql="INSERT INTO u_p_m(u_id,p_id) VALUES(?,?)";
        try {
            connection= Jdbc_util.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,rela_user.getU_id());
            preparedStatement.setInt(2,rela_user.getP_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }finally {
            Jdbc_util.close(connection,preparedStatement);
        }
    }

    @Override
    public List<Rela_user> findbyid(int u_id) {
        String sql="select * from u_p_m where u_id=?";
        List<Rela_user> rela_userList=new ArrayList<Rela_user>();
        try {
            connection= Jdbc_util.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,u_id);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Rela_user rela_user=new Rela_user();
                rela_user.setP_u_id(resultSet.getInt("u_p_id"));
                rela_user.setU_id(u_id);
                rela_user.setP_id(resultSet.getInt("p_id"));
                rela_userList.add(rela_user);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }finally {
            Jdbc_util.close(connection,preparedStatement,resultSet);
        }
        return rela_userList;
    }

    @Override
    public void remove(int u_id,int p_id) {
        String sql="delete from u_p_m where u_id=? and p_id=?";
        try {
            connection= Jdbc_util.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,u_id);
            preparedStatement.setInt(2,p_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }finally {
            Jdbc_util.close(connection,preparedStatement);
        }

    }
}
