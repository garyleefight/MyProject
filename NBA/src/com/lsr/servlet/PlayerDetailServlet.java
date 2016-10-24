package com.lsr.servlet;

import com.lsr.entity.Player;
import com.lsr.entity.Playerdata;
import com.lsr.service.impl.DataService;
import com.lsr.service.impl.DetailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.List;

/**
 * Created by lsr on 16/10/6.
 */
@WebServlet(name = "PlayerDetailServlet",urlPatterns = {"/playerdetail"})
public class PlayerDetailServlet extends HttpServlet {
            DetailService detailService=new DetailService();
            DataService dataService=new DataService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                if(request.getParameter("id")!=null){
                String s=request.getParameter("id");
                    long b=System.currentTimeMillis();
                    idmatch(request, response, s);
                    System.out.println(System.currentTimeMillis()-b);
                return;
                }

                if(request.getParameter("psid")!=null){
                    Player player=detailService.findplayer(Integer.parseInt(request.getParameter("psid")));
                    request.setAttribute("player",player);
                    request.getRequestDispatcher("/WEB-INF/revise.jsp").forward(request,response);
                    return;
                }

                if(request.getParameter("pid")!=null){
                    try {
                        Playerdata playerdata=new Playerdata();
                        playerdata.setP_s_id(Integer.parseInt(request.getParameter("pid")));
                        playerdata.setGameplay(Integer.parseInt(request.getParameter("gp")));
                        playerdata.setRebound(Float.parseFloat(request.getParameter("rebound")));
                        playerdata.setAssist(Float.parseFloat(request.getParameter("assist")));
                        playerdata.setTurnover(Float.parseFloat(request.getParameter("turnover")));
                        playerdata.setSteal(Float.parseFloat(request.getParameter("steal")));
                        playerdata.setBlock(Float.parseFloat(request.getParameter("block")));
                        playerdata.setFoul(Float.parseFloat(request.getParameter("foul")));
                        playerdata.setScore(Float.parseFloat(request.getParameter("point")));
                        detailService.revise(playerdata);
                        String s=request.getParameter("plid");
                        if(s!=null){
                            idmatch(request,response,s);
                        }
                    } catch (NumberFormatException e) {
                        response.getWriter().write("<script language='javascript'>alert('Wrong Input Format!')</script>");
                    } catch (ServletException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

    }

    private void idmatch(HttpServletRequest request, HttpServletResponse response, String s) throws ServletException, IOException {
        int id=Integer.parseInt(s);
        Player player=dataService.findbyid(id);
        request.setAttribute("player",player);
        List<Player> playerList=detailService.find(id);
        request.setAttribute("playerList",playerList);
        request.getRequestDispatcher("/WEB-INF/playerdetail.jsp").forward(request,response);
    }
}
