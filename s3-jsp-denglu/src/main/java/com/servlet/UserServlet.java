package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p=request.getParameter("p");
        if ("zhuce".equals(p)){
            doZhuce(request,response);
        }
    }

    private void doZhuce(HttpServletRequest request, HttpServletResponse response) {

    }
}
