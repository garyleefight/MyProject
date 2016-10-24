package com.lsr.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by lsr on 16/10/3.
 */
public class Jdbc_util {
    private static String url;
    private static String user;
    private static String password;
    private static String classname;
    static {
        try {
            Properties properties=new Properties();
            InputStream inputStream=Jdbc_util.class.getResourceAsStream("/userinfo.properties");
            properties.load(inputStream);
            url=properties.getProperty("url");
            user=properties.getProperty("user");
            password=properties.getProperty("password");
            classname=properties.getProperty("classname");
            try {
                Class.forName(classname);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    public static Connection getConnection(){
        try {
            Connection connection=DriverManager.getConnection(url,user,password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    public static void close(Connection connection,Statement statement){
        try {
            if(statement!=null){
                statement.close();
                statement=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        if(connection!=null){
            try {
                connection.close();
                connection=null;
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
    }

    public static void close(Connection connection,Statement statement,ResultSet resultSet){
        if(resultSet!=null){
            try {
                resultSet.close();
                resultSet=null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            if(statement!=null){
                statement.close();
                statement=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        if(connection!=null){
            try {
                connection.close();
                connection=null;
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
    }

    public static void close(Statement statement,ResultSet resultSet){
        if(resultSet!=null){
            try {
                resultSet.close();
                resultSet=null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            if(statement!=null){
                statement.close();
                statement=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }


}
