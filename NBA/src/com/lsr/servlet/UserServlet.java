package com.lsr.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by lsr on 16/10/5.
 */
@WebServlet(name = "UserServlet",urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session=request.getSession(false);
            if(session!=null) {
                if (session.getAttribute("username") == null) {
                    //user try to directly login
                    response.sendRedirect(request.getContextPath() + "/login.jsp");
                    return;
                } else {
                    if (request.getParameter("method") != null) {
                        if (request.getParameter("method").equals("logout")) {
                            session.removeAttribute("username");
                            session.removeAttribute("userid");
                            response.sendRedirect(request.getContextPath() + "/login.jsp");
                            return;
                        }
                    }
                    request.getRequestDispatcher("/WEB-INF/user_page.jsp").forward(request, response);

                }
            }else{
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            }


    }
}
