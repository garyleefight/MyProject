package com.lsr.dao.impl;

import com.lsr.dao.IAdminDao;
import com.lsr.entity.Admin;
import com.lsr.util.Jdbc_util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lsr on 16/10/4.
 */
public class AdminDao  implements IAdminDao{
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    @Override
    public void save(Admin admin) {
        String sql="INSERT INTO admin(a_name,password) VALUES(?,?)";
        try {
            connection= Jdbc_util.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,admin.getA_name());
            preparedStatement.setString(2,admin.getA_password());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }finally {
            Jdbc_util.close(connection,preparedStatement);
        }

    }

    @Override
    public Admin findByName(Admin admin) {
       String sql="select * from admin where a_name=? and password=?";
        Admin admin_result=null;
        try {
            connection= Jdbc_util.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,admin.getA_name());
            preparedStatement.setString(2,admin.getA_password());
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                admin_result =new Admin();
                admin_result.setA_id(resultSet.getInt("id"));
                admin_result.setA_name(resultSet.getString("a_name"));
                admin_result.setA_password(resultSet.getString("password"));

            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }finally {
            Jdbc_util.close(connection,preparedStatement,resultSet);
        }
        return admin_result;
    }

    @Override
    public boolean userExists(Admin admin) {
        String sql="SELECT password from admin where a_name=?";
        try {
            connection= Jdbc_util.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,admin.getA_name());
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                String password=resultSet.getString("password");
                if(password!=null){
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException();
        }finally {
            Jdbc_util.close(connection,preparedStatement,resultSet);
        }

    }
}
