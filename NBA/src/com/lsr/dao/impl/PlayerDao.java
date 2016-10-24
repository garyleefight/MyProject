package com.lsr.dao.impl;

import com.lsr.dao.IPlayerDao;
import com.lsr.entity.Player;
import com.lsr.entity.Team;
import com.lsr.util.Jdbc_util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.currentTimeMillis;

/**
 * Created by lsr on 16/10/5.
 */
public class PlayerDao implements IPlayerDao{
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<Player> playerList;
    int flag;

    public PlayerDao(Connection connection) {
        this.connection = connection;
        flag=1;
    }

    public PlayerDao() {
        flag=0;
    }

    @Override
    public Player findbyname(String name) {
        return null;
    }

    @Override
    public List<Player> findall() {
        String sql="SELECT * FROM player_info";
        playerList=new ArrayList<Player>();
        try {
            if(flag==0){
            connection= Jdbc_util.getConnection();}
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Player player = getPlayer();
                playerList.add(player);
                //      to do search team in the player team
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

        return playerList;
    }

    @Override
    public List<Player> findbyteam(String name) {
        return null;
    }

    @Override
    public Player findbyId(int id) {
        String sql="SELECT * FROM player_info WHERE p_id=?";
        try {
            if(flag==0){
            connection= Jdbc_util.getConnection();}
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                Player player = getPlayer();
                //      to do search team in the player team
                return player;
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

        return null;
    }

    @Override
    public void delete(int p_id) {
        String sql="DELETE FROM player_info WHERE p_id=?";
        try {
            if(flag==0){
                connection= Jdbc_util.getConnection();}
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,p_id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Jdbc_util.close(connection,preparedStatement);
        }


    }

    private Player getPlayer() throws SQLException {
        int p_id=resultSet.getInt("p_id");
        String p_name=resultSet.getString("p_name");
        int num=resultSet.getInt("num");
        String pos=resultSet.getString("pos");
        String height=resultSet.getString("height");
        int weight=resultSet.getInt("weight");
        String birthdate=resultSet.getString("birthdate");
        int age=resultSet.getInt("age");
        String exp=resultSet.getString("exp");
        Player player=new Player();
        player.setP_id(p_id);
        player.setP_name(p_name);
        player.setNum(num);
        player.setPos(pos);
        player.setHeight(height);
        player.setWeight(weight);
        player.setBirthdate(birthdate);
        player.setAge(age);
        player.setExp(exp);
        return player;
    }
}
