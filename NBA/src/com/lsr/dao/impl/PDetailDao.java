package com.lsr.dao.impl;

import com.lsr.dao.IPDetailDao;
import com.lsr.entity.Playerdata;
import com.lsr.util.Jdbc_util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lsr on 16/10/6.
 */
public class PDetailDao implements IPDetailDao{
    Connection connection=null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;
    int flag;

    public PDetailDao(Connection connection) {
        this.connection = connection;
        flag=1;
    }

    public PDetailDao() {
        flag=0;
    }

    @Override
    public void revise(Playerdata playerdata) {
        String sql="UPDATE player_semester  SET gameplay=?,rebound=?,assist=?,turnover=?,steal=?,block=?,foul=?,score=? WHERE p_s_id=? ";
        try {
            connection=Jdbc_util.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,playerdata.getGameplay());
            preparedStatement.setFloat(2,playerdata.getRebound());
            preparedStatement.setFloat(3,playerdata.getAssist());
            preparedStatement.setFloat(4,playerdata.getTurnover());
            preparedStatement.setFloat(5,playerdata.getSteal());
            preparedStatement.setFloat(6,playerdata.getBlock());
            preparedStatement.setFloat(7,playerdata.getFoul());
            preparedStatement.setFloat(8,playerdata.getScore());
            preparedStatement.setInt(9,playerdata.getP_s_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Jdbc_util.close(connection,preparedStatement);
        }

    }

    @Override
    public List<Playerdata> findplayer(int p_id) {
        List<Playerdata> playerList=new ArrayList<Playerdata>();
        String sql="SELECT * FROM player_semester where p_id=?";
        mainmethod(p_id, playerList, sql);
        return playerList;
    }

    private void mainmethod(int p_id, List<Playerdata> playerList, String sql) {
        try {
            if(flag==0){
                connection= Jdbc_util.getConnection();}
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,p_id);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Playerdata playerdata =getPlayerdata();
                playerList.add(playerdata);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(flag==0){
                Jdbc_util.close(connection,preparedStatement,resultSet);
                System.out.println("I'm in");
            }

            if (flag == 1) {
                Jdbc_util.close(preparedStatement,resultSet);
            }
        }
    }

    @Override
    public List<Playerdata> findteam(int t_id) {
        List<Playerdata> playerList=new ArrayList<Playerdata>();
        String sql="SELECT * FROM player_semester where t_id=?";
        mainmethod(t_id, playerList, sql);
        return playerList;
    }

    @Override
    public Playerdata findone1(int psid) {
        Playerdata playerdata=null;
        String sql="SELECT * FROM player_semester where p_s_id=?";
        try {
            if(flag==0){
                connection= Jdbc_util.getConnection();}
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,psid);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                playerdata = getPlayerdata();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(flag==0){
                Jdbc_util.close(connection,preparedStatement,resultSet);
            }

            if (flag == 1) {
                Jdbc_util.close(preparedStatement,resultSet);
            }
        }
        return playerdata;
    }

    private Playerdata getPlayerdata() throws SQLException {
        Playerdata playerdata;
        playerdata = new Playerdata();
        playerdata.setP_s_id(resultSet.getInt("p_s_id"));
        playerdata.setP_id(resultSet.getInt("p_id"));
        playerdata.setS_id(resultSet.getInt("s_id"));
        playerdata.setT_id(resultSet.getInt("t_id"));
        playerdata.setScore(resultSet.getFloat("score"));
        playerdata.setBlock(resultSet.getFloat("block"));
        playerdata.setAssist(resultSet.getFloat("assist"));
        playerdata.setRebound(resultSet.getFloat("rebound"));
        playerdata.setTurnover(resultSet.getFloat("turnover"));
        playerdata.setFoul(resultSet.getFloat("foul"));
        playerdata.setSteal(resultSet.getFloat("steal"));
        playerdata.setGameplay(resultSet.getInt("gameplay"));
        return playerdata;
    }


}
