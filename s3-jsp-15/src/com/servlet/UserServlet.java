package com.servlet;

import com.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServlet extends javax.servlet.http.HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //如何获取session 对象
        HttpSession session = request.getSession();


        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sql = "select username,password from userinfo where username=? and password=?";
        ResultSet rs = DBUtil.query(sql,username,password);
        try {
            if(rs.next()){
                session.setAttribute("username" , username);
                request.getRequestDispatcher("main.jsp").forward(request,response);
            }else {
                response.sendRedirect("login.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
