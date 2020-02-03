package com.servlet;

import com.dao.UserDAO;
import com.pojo.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    private UserDAO userDAO = new UserDAO();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String p = request.getParameter("p");

        if("login".equals(p)){
            doLogin(request ,response);
        }

        if("regist".equals(p)){
            doRegist(request , response);
        }


    }

    //注册
    private void doRegist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        int n = userDAO.regist(username , password);
        if(n>0){
            //使用重定向  避免数据的重复提交
            response.sendRedirect("login.jsp");
            return ;
        }

        response.sendRedirect("regist.jsp");



    }

    //登录
    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("user");
        String password = request.getParameter("word");

        UserInfo userInfo = userDAO.login(username , password);

        if(userInfo==null){
            response.sendRedirect("index.jsp");
            return ;
        }

        request.getRequestDispatcher("main.jsp").forward(request ,response);








    }
}
