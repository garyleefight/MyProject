package com.lsr.dao;

import com.lsr.entity.Team;

import java.util.List;

/**
 * Created by lsr on 16/10/5.
 */
public interface ITeamDao {
     Team findbyID(int id);

     List<Team> findall();
}
