package com.servlet;

import com.mapper.UserDAO;
import com.pojo.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServlet extends HttpServlet {

    private UserDAO userDAO = new UserDAO();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p = request.getParameter("p");
        if("findall".equals(p)){
            doFindAll(request , response);
        }
    }

    //查找所有用户
    private void doFindAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1 ;
        int size = 4 ;
        String pageString = request.getParameter("page");
        String sizeString = request.getParameter("size");
        if(pageString!=null && pageString.trim().length()>0){
            page = Integer.parseInt(pageString);
        }
        if(sizeString!=null && sizeString.trim().length()>0){
            size = Integer.parseInt(sizeString);
        }

        //越界判断
        if(page<1){
            page = 1 ;
        }
        //指定的页数大于总页数   求总条数
        int count = userDAO.getCount();
        //总页数
        int pageCount = count %size == 0 ? count /size : count /size + 1 ;
        if(page>pageCount){
            page = pageCount;
        }

        List<UserInfo> list = userDAO.findall(page, size);

        Map map = new HashMap();
        map.put("page" , page);
        map.put("size" , size);
        map.put("count" , count);
        map.put("pageCount" , pageCount);
        map.put("list" , list);

        request.setAttribute("map" , map);
        request.getRequestDispatcher("show.jsp").forward(request , response);
    }
}
