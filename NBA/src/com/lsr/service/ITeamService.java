package com.lsr.service;

import com.lsr.entity.Team;

import java.util.List;

/**
 * Created by lsr on 16/10/8.
 */
public interface ITeamService {
    List<Team> findall();
    Team findbyid(int t_id);
}
