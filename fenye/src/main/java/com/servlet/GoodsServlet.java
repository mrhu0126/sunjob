package com.servlet;

import com.dao.GoodsDAO;
import com.pojo.Goods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodsServlet extends HttpServlet {

    private GoodsDAO goodsDAO = new GoodsDAO();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String p = request.getParameter("p");
        if("fenye".equals(p)){
            doFenye(request , response);
        }



    }

    private void doFenye(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1 ;
        int size = 4 ;

        //在判断用户是否给定了参数值
        String pageString = request.getParameter("page");
        if(pageString!=null && pageString.trim().length()>0){
            page = Integer.parseInt(pageString);
        }

        String sizeString = request.getParameter("size");
        if(sizeString!=null && sizeString.trim().length()>0){
            size = Integer.parseInt(sizeString);
        }

        if(page<1){
            page = 1 ;
        }


        //查总条数
        int count = goodsDAO.getCount();
        //求总页数
        int pageCount = count%size ==0 ? count /size : count /size + 1 ;

        if(page>pageCount){
            page = pageCount;
        }

        List<Goods> list = goodsDAO.fenye(page , size);
        Map map = new HashMap();
        map.put("page" ,page );
        map.put("size" , size);
        map.put("count" , count);
        map.put("pageCount" , pageCount);
        map.put("list" , list);
        request.setAttribute("map" , map);
        request.getRequestDispatcher("main.jsp").forward(request , response);



    }
}
