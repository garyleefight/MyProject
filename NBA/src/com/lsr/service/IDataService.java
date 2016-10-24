package com.lsr.service;

import com.lsr.entity.Player;

import java.util.List;

/**
 * Created by lsr on 16/10/6.
 */
public interface IDataService {
    List<Player> p_findall();
    Player findbyid(int id);
    void delete(int id);
}
