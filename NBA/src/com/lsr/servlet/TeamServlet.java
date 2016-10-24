package com.lsr.servlet;

import com.lsr.entity.Player;
import com.lsr.entity.Team;
import com.lsr.service.impl.DetailService;
import com.lsr.service.impl.TeamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lsr on 16/10/8.
 */
@WebServlet(name = "TeamServlet",urlPatterns = {"/team"})
public class TeamServlet extends HttpServlet {
    TeamService teamService=new TeamService();
    DetailService detailService=new DetailService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                if(request.getParameter("method")!=null){
                if(request.getParameter("method").equals("showteam")){
                    request.setAttribute("showall",teamService.findall());
                    request.getRequestDispatcher("/WEB-INF/team.jsp").forward(request,response);
                    return;
                }}

                if(request.getParameter("id")!=null){
                    List<Player> id = detailService.findteam(Integer.parseInt(request.getParameter("id")));
                    List<Player> []list=new List[3];
                    for(int i=0;i<list.length;i++){
                        list[i]=new ArrayList<Player>();
                    }
                    for (Player p:id) {
                            list[p.getPlayerdata().getS_id()-1].add(p);
                    }
                    request.setAttribute("showteam", list);
                    request.setAttribute("team",teamService.findbyid(Integer.parseInt(request.getParameter("id"))));
                    request.getRequestDispatcher("/WEB-INF/teamdetail.jsp").forward(request,response);
                    return;
                }
    }
}
