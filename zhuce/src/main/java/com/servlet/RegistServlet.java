package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistServlet")
public class RegistServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String p = request.getParameter("p"); 
            
            if ("findall".equals(p)){
                doFindall(request,response);
            }
    }

    private void doFindall(HttpServletRequest request, HttpServletResponse response) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

    }
}
