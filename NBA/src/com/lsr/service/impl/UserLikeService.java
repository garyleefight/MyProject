package com.lsr.service.impl;

import com.lsr.dao.impl.MiddleUserDao;
import com.lsr.dao.impl.PlayerDao;
import com.lsr.entity.Player;
import com.lsr.entity.Rela_user;
import com.lsr.service.IUserLikeService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lsr on 16/10/8.
 */
public class UserLikeService implements IUserLikeService{
    MiddleUserDao middleUserDao=new MiddleUserDao();
    PlayerDao playerDao=new PlayerDao();
    @Override
    public List<Player> findby(int u_id) {
        List<Rela_user> list=middleUserDao.findbyid(u_id);
        List<Player> playerList=new ArrayList<Player>();
        for(Rela_user rela_user:list){
            playerList.add(playerDao.findbyId(rela_user.getP_id()));
        }
        return playerList;
    }

    @Override
    public void save(int u_id, int p_id) {
        Rela_user rela_user=new Rela_user();
        rela_user.setP_id(p_id);
        rela_user.setU_id(u_id);
        middleUserDao.save(rela_user);
    }

    @Override
    public Boolean contains(int u_id, int p_id) {
        List<Rela_user> list=middleUserDao.findbyid(u_id);
        for(Rela_user rela_user:list){
            if(rela_user.getP_id()==p_id){
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(int u_id, int p_id) {
        middleUserDao.remove(u_id,p_id);
    }
}
