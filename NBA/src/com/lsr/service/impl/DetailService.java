package com.lsr.service.impl;

import com.lsr.dao.IPDetailDao;
import com.lsr.dao.impl.*;
import com.lsr.entity.Player;
import com.lsr.entity.Playerdata;
import com.lsr.service.IDetailService;
import com.lsr.util.Jdbc_util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lsr on 16/10/6.
 */
public class DetailService implements IDetailService{
    IPDetailDao ipDetailDao;
    PlayerDao playerdao;
    TeamDao teamdao;
    SemesterDao semesterDao;

    @Override
    public List<Player> find(int id) {
        //consume a lot of time!
        Connection connection= Jdbc_util.getConnection();
        List<Player> list=new ArrayList<Player>();
        ipDetailDao=new PDetailDao(connection);
        List<Playerdata> list_playerdata=ipDetailDao.findplayer(id);
        for (Playerdata p:list_playerdata) {
            playerdao=new PlayerDao(connection);
            Player player=playerdao.findbyId(p.getP_id());
            player.setPlayerdata(p);
            teamdao=new TeamDao(connection);
            player.setTeam(teamdao.findbyID(p.getT_id()).getT_name());
            semesterDao=new SemesterDao(connection);
            player.setSemester(semesterDao.findbyid(p.getS_id()));
            list.add(player);
        }
        try {
            connection.close();
            connection=null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Player> findteam(int t_id) {
        Connection connection= Jdbc_util.getConnection();
        List<Player> list=new ArrayList<Player>();
        ipDetailDao=new PDetailDao(connection);
        List<Playerdata> list_playerdata=ipDetailDao.findteam(t_id);
        for (Playerdata p:list_playerdata) {
            playerdao=new PlayerDao(connection);
            Player player=playerdao.findbyId(p.getP_id());
            player.setPlayerdata(p);
            teamdao=new TeamDao(connection);
            player.setTeam(teamdao.findbyID(p.getT_id()).getT_name());
            semesterDao=new SemesterDao(connection);
            player.setSemester(semesterDao.findbyid(p.getS_id()));
            list.add(player);
        }
        try {
            connection.close();
            connection=null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }





    @Override
    public Player findplayer(int p_s_id) {
        Connection connection= Jdbc_util.getConnection();
        ipDetailDao=new PDetailDao(connection);
        Playerdata playerdata=ipDetailDao.findone1(p_s_id);
        playerdao=new PlayerDao(connection);
        Player player=playerdao.findbyId(playerdata.getP_id());
        player.setPlayerdata(playerdata);
        teamdao=new TeamDao(connection);
        player.setTeam(teamdao.findbyID(playerdata.getT_id()).getT_name());
        semesterDao=new SemesterDao(connection);
        player.setSemester(semesterDao.findbyid(playerdata.getS_id()));
        return player;
    }

    @Override
    public void revise(Playerdata playerdata) {
        ipDetailDao.revise(playerdata);
    }

}
