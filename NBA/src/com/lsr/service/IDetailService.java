package com.lsr.service;

import com.lsr.entity.Player;
import com.lsr.entity.Playerdata;

import java.util.List;

/**
 * Created by lsr on 16/10/6.
 */
public interface IDetailService {
    List<Player> find(int id);
    List<Player> findteam(int t_id);
    Player findplayer(int p_s_id);
    void revise(Playerdata playerdata);
}
