package com.lsr.dao.impl;

import com.lsr.dao.ISemesterDao;
import com.lsr.util.Jdbc_util;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;

/**
 * Created by lsr on 16/10/7.
 */
public class SemesterDao implements ISemesterDao{
    Connection connection=null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;
    int flag;

    public SemesterDao(Connection connection) {
        this.connection = connection;
        this.flag=1;
    }

    public SemesterDao() {
        this.flag=0;
    }

    @Override
    public String findbyid(int id) {

        String sql="SELECT * from s_info where s_id=?";
        String semester=null;
        try {
            if(flag==0){
            connection=  Jdbc_util.getConnection();}
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                semester=resultSet.getString("season");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(flag==0){
                Jdbc_util.close(connection,preparedStatement,resultSet);
            }

            if (flag == 1) {
                Jdbc_util.close(preparedStatement,resultSet);
            }
        }
        return semester;
    }
}
