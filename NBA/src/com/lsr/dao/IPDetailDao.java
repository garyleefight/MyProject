package com.lsr.dao;

import com.lsr.entity.Playerdata;

import java.util.List;

/**
 * Created by lsr on 16/10/6.
 */
public interface IPDetailDao {

    void revise(Playerdata playerdata);

    List<Playerdata> findplayer(int p_id);

    List<Playerdata> findteam(int t_id);

    Playerdata findone1(int psid);
}
