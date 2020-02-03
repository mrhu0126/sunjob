package com.servlet;

import com.dao.UserDAO;
import com.pojo.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    private UserDAO userDAO = new UserDAO();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理服务器到客户端乱码
        response.setContentType("text/html;charset=utf-8");

        String p =request.getParameter("p");
        if("regist".equals(p)){
            doRegist(request , response);
        }

        if("login".equals(p)){
            doLogin(request , response);
        }

    }

    //登录
    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserInfo userInfo = userDAO.login(username , password);
        if(userInfo!=null){
            request.getSession().setAttribute("userinfo" , userInfo);
            request.getRequestDispatcher("main.jsp").forward(request , response);
            return ;
        }

        response.sendRedirect("login.jsp");

    }

    //注册
    private void doRegist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        int n = userDAO.regist(username , password);

        if(n>0){
            response.getWriter().println("<script>alert('注册成功');location='login.jsp';</script>");
            return ;
        }

        response.sendRedirect("index.jsp");

    }
}
