package com.lsr.servlet;

import com.lsr.entity.Player;
import com.lsr.service.impl.DataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by lsr on 16/10/5.
 */
@WebServlet(name = "PlayerServlet",urlPatterns = {"/player"})
public class PlayerServlet extends HttpServlet {
    DataService dataService=new DataService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                if("showall".equals(request.getParameter("method"))){
                    //show all players
                    showAllPlayers(request, response);
                    return;
                }

                if(request.getParameter("delete")!=null){
                    int p_id= Integer.parseInt(request.getParameter("delete"));
                    dataService.delete(p_id);
                    showAllPlayers(request,response);
                }
    }

    private void showAllPlayers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Player> playerList=dataService.p_findall();
        request.setAttribute("allplayerlist",playerList);
        request.getRequestDispatcher("/WEB-INF/main.jsp").forward(request,response);
    }
}
