package com.lsr.dao;

import com.lsr.entity.Rela_user;

import java.util.List;

/**
 * Created by lsr on 16/10/8.
 */
public interface IMiddleUser {
    void save(Rela_user rela_user);

    List<Rela_user> findbyid(int id);

    void remove(int u_id,int p_id);
}
