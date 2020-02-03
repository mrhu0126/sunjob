package com.servlet;

import com.dao.DepDAO;
import com.pojo.Dep;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DepServlet extends HttpServlet {

    private DepDAO depdao = new DepDAO();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String p = request.getParameter("p");

        if("findall".equals(p)){
            doFindAll(request , response);
        }


    }

    private void doFindAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Dep> list = depdao.findall();

        if(list.size()==0){
            response.getWriter().println("[]");
            return ;
        }

        StringBuffer sb = new StringBuffer("[");
        // [{'depid':'1','depname':'小卖部'},{'depid':'2','depname':'国防部'}]
        for (Dep dep : list) {
            sb.append("{'depid':'").append(dep.getDepid()).
                    append("','depname':'").append(dep.getDepname()).append("'},");
        }

        sb.replace(sb.length()-1 , sb.length() , "]");
        String json = sb.toString();
        response.getWriter().println(json);


    }
}
