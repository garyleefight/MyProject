package com.lsr.servlet;

import com.lsr.entity.Player;
import com.lsr.service.impl.UserLikeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by lsr on 16/10/8.
 */
@WebServlet(name = "UserLikeServlet",urlPatterns = {"/userlike"})
public class UserLikeServlet extends HttpServlet {
    UserLikeService userLikeService=new UserLikeService();
    HttpSession httpSession=null;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                    //add favor situation
                    if(request.getParameter("id")!=null){
                        Integer p_id=Integer.parseInt(request.getParameter("id"));
                        httpSession = request.getSession();
                        Integer u_id = (Integer) httpSession.getAttribute("userid");
                        if (u_id != null) {
                            if (userLikeService.contains(u_id, p_id)) {
                                response.getWriter().write("<script language='javascript'>alert('You Have Already Followed This Player!')</script>");
                                return;
                            }
                            userLikeService.save(u_id, p_id);
                            response.getWriter().write("<script language='javascript'>alert('Add Success!')</script>");
                            return;
                        }
                        if (u_id == null) {
                            request.setAttribute("messege", "Please Login Now!");
                            request.getRequestDispatcher("/login.jsp").forward(request, response);
                            return;
                        }
                    }

                    if(request.getParameter("rid")!=null){
                        Integer p_id=Integer.parseInt(request.getParameter("rid"));
                        httpSession = request.getSession();
                        Integer u_id = (Integer) httpSession.getAttribute("userid");
                        if (u_id == null) {
                            request.setAttribute("messege", "Please Login Now!");
                            request.getRequestDispatcher("/login.jsp").forward(request, response);
                            return;
                        }
                        userLikeService.remove(u_id,p_id);
                        this.showall(request,response,u_id);
                    }
                    //show list
                    if("showfavor".equals(request.getParameter("method"))){
                        httpSession=request.getSession();
                        if(httpSession.getAttribute("userid")!=null){
                        Integer u_id = (Integer) httpSession.getAttribute("userid");
                        showall(request, response, u_id);}
                        else{
                            request.setAttribute("messege", "Please Login Now!");
                            request.getRequestDispatcher("/login.jsp").forward(request, response);
                            return;
                        }
                    }

    }

    private void showall(HttpServletRequest request, HttpServletResponse response, Integer u_id) throws ServletException, IOException {
        List<Player> list=userLikeService.findby(u_id);
        request.setAttribute("playerlist",list);
        request.getRequestDispatcher("/WEB-INF/myfavor.jsp").forward(request,response);
    }
}
