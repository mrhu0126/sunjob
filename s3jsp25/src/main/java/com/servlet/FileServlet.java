package com.servlet;

import com.oreilly.servlet.MultipartRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FileServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String path = request.getSession().getServletContext().getRealPath("image");
        MultipartRequest mr = new MultipartRequest(request,path ,100*1024*1024 , "utf-8");
       // request.getParameter("")   不能使用此方法取值
        String username = mr.getParameter("username");
        System.out.println(username);
        String filename = mr.getFile("pic").getName();
        System.out.println(filename);
    }
}

