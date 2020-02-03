package com.servlet;

import com.dao.DepDAO;
import com.pojo.Dep;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DepServlet extends javax.servlet.http.HttpServlet {

    private DepDAO depDAO = new DepDAO();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        List<Dep> list = depDAO.findall();
        //   [{'depid':'1' , 'depname':'小卖部'},{'depid':'2' , 'depname':'体育部'}]
        StringBuffer sb = new StringBuffer("[");

        for (Dep dep : list) {
            sb.append("{'depid':'").append(dep.getDepid()).append("' , 'depname':'").append(dep.getDepname()).append("'},");
        }
        sb.replace(sb.length()-1, sb.length(),"]")  ;

        String s = sb.toString();

        response.getWriter().println(s);

    }
}
