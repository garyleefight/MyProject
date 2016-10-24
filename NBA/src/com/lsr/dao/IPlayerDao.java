package com.lsr.dao;

import com.lsr.entity.Player;

import java.util.List;

/**
 * Created by lsr on 16/10/5.
 */
public interface IPlayerDao {
    //user can search by inputing the player's name
    Player findbyname(String name);

    //return all player in the main page
    List<Player> findall();

    //return players by inputing the team's name
    List<Player> findbyteam(String name);

    Player findbyId(int id);

    void delete(int p_id);

}
