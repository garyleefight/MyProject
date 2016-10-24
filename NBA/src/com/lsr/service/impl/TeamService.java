package com.lsr.service.impl;

import com.lsr.dao.impl.TeamDao;
import com.lsr.entity.Team;
import com.lsr.service.ITeamService;

import java.util.List;

/**
 * Created by lsr on 16/10/8.
 */
public class TeamService implements ITeamService{
    TeamDao teamDao=new TeamDao();
    @Override
    public List<Team> findall() {
        return teamDao.findall();
    }

    @Override
    public Team findbyid(int t_id){
        return teamDao.findbyID(t_id);
    }
}
