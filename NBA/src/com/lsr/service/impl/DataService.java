package com.lsr.service.impl;

import com.lsr.dao.impl.PlayerDao;
import com.lsr.entity.Player;
import com.lsr.service.IDataService;

import java.util.List;

/**
 * Created by lsr on 16/10/5.
 */
public class DataService implements IDataService{
    private PlayerDao playerDao=new PlayerDao();
    private List<Player> playerList=null;

    public List<Player> p_findall(){
        return playerList=playerDao.findall();
    }

    @Override
    public Player findbyid(int id) {
        return playerDao.findbyId(id);
    }

    @Override
    public void delete(int id) {
        playerDao.delete(id);
    }


}
