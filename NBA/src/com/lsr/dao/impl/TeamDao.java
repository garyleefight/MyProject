package com.lsr.dao.impl;

import com.lsr.dao.ITeamDao;
import com.lsr.entity.Team;
import com.lsr.util.Jdbc_util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lsr on 16/10/5.
 */
public class TeamDao implements ITeamDao{
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    int flag;

    public TeamDao(Connection connection) {
        this.connection = connection;
        flag=1;
    }

    public TeamDao() {
        flag=0;
    }

    @Override
    public  Team findbyID(int id) {
        String sql="SELECT * FROM team_info WHERE t_id=?";
        Team team=null;
        try {
            if(flag==0){
            connection= Jdbc_util.getConnection();}
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                team=new Team();
                team.setT_id(resultSet.getInt("t_id"));
                team.setT_name(resultSet.getString("t_name"));
                team.setT_loc(resultSet.getString("t_loc"));
                team.setT_div(resultSet.getString("t_part"));
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

        return team;
    }

    @Override
    public List<Team> findall() {
        String sql="SELECT * FROM team_info";
        List<Team> teamList=new ArrayList<Team>();
        try {
            if(flag==0){
            connection= Jdbc_util.getConnection();}
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Team team=new Team();
                team.setT_id(resultSet.getInt("t_id"));
                team.setT_name(resultSet.getString("t_name"));
                team.setT_loc(resultSet.getString("t_loc"));
                team.setT_div(resultSet.getString("t_part"));
                teamList.add(team);
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

        return teamList;
    }
}
