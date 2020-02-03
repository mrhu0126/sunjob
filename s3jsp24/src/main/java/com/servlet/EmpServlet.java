package com.servlet;

import com.dao.EmpDAO;
import com.pojo.Emp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EmpServlet extends HttpServlet {

    private EmpDAO empdao = new EmpDAO();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String p = request.getParameter("p");
        if("findempbydid".equals(p)){
            doFindEmpByDid(request , response);
        }

    }

    private void doFindEmpByDid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String did = request.getParameter("did");
        List<Emp> list = empdao.findEmpBydid(did);

        // [{'empid':'1','empname':'张三'},{'empid':'2' ,'empname':'李四'},{'empid':'3' ,'empname':'王五'}]
        if(list.size()==0){
            response.getWriter().println("[]");
            return ;
        }

        StringBuffer sb = new StringBuffer("[");

        for (Emp emp : list) {
            sb.append("{'empid':'").append(emp.getEmpid()).append("','empname':'").
                    append(emp.getEmpname()).append("'},");
        }

        sb.replace(sb.length()-1 , sb.length() , "]");
        String json = sb.toString();
        response.getWriter().println(json);

    }
}
