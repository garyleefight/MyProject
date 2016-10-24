package com.lsr.servlet;

import com.lsr.entity.Admin;
import com.lsr.exception.UserExistsException;
import com.lsr.service.impl.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by lsr on 16/10/4.
 */
@WebServlet(name = "AdminServlet",urlPatterns = {"/admin"})
public class AdminServlet extends HttpServlet {
    AdminService adminService=new AdminService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String method=request.getParameter("method");
            if("register".equals(method)){
                register(request,response);
            }else if("login".equals(method)){
                login(request,response);
            }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Admin admin=new Admin();
            admin.setA_name(request.getParameter("user"));
            admin.setA_password(request.getParameter("password"));
            Admin admin_result=adminService.login(admin);
            if(admin_result!=null){
                //login successfully
                HttpSession session=request.getSession();
                session.setAttribute("userid",admin_result.getA_id());
                session.setAttribute("username",request.getParameter("user"));
                response.sendRedirect(request.getContextPath()+"/user");
            }else{
                request.setAttribute("messege","user name and password are not matched");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
    }

    private void register(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        Admin admin=new Admin();
        if(request.getParameter("user")==null||request.getParameter("user")==""){
            request.setAttribute("message","Username Can not be null");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return;
        }
        if(request.getParameter("password")==null||request.getParameter("password").equals("")){
            request.setAttribute("message","Password Can not be null");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return;
        }

        if(!request.getParameter("password").equals(request.getParameter("password1"))){
            request.setAttribute("message","Please Re-Enter The Same Password");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return;
        }
        admin.setA_name(request.getParameter("user"));
        admin.setA_password(request.getParameter("password"));
        try {
            adminService.register(admin);
            admin=adminService.login(admin);
            HttpSession session=request.getSession();
            session.setAttribute("userid",admin.getA_id());
            session.setAttribute("username",request.getParameter("user"));
            response.sendRedirect(request.getContextPath()+"/user");
        } catch (UserExistsException e) {
            //fail to rigister and dispatch to register.jsp
            request.setAttribute("message","This user name is used");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }catch (Exception e){
            //other problems and redirect to error.jsp
            response.sendRedirect(request.getContextPath()+"/error.jsp");
            e.printStackTrace();
        }
    }
}
