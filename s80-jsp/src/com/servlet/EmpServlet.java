package com.servlet;

import com.dao.EmpDAO;
import com.pojo.Dep;
import com.pojo.Emp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EmpServlet extends HttpServlet {

    private EmpDAO empDAO = new EmpDAO();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String depid = request.getParameter("depid");
        List<Emp> list = empDAO.findbyid(depid);

        StringBuffer sb = new StringBuffer("[");

        for (Emp emp : list) {
            sb.append("{'empid':'").append(emp.getEmpid()).append("' , 'empname':'").append(emp.getEmpname()).append("'},");
        }
        sb.replace(sb.length()-1, sb.length(),"]")  ;

        String s = sb.toString();

        response.getWriter().println(s);






    }
}
