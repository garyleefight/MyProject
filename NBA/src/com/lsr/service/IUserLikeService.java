package com.lsr.service;

import com.lsr.entity.Player;
import com.lsr.entity.Rela_user;

import java.util.List;

/**
 * Created by lsr on 16/10/8.
 */
public interface IUserLikeService {
    List<Player> findby(int u_id);

    void save(int u_id,int p_id);

    Boolean contains(int u_id,int p_id);

    void remove(int u_id,int p_id);
}
