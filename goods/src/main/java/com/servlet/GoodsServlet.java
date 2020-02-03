package com.servlet;

import com.dao.GoodsDAO;
import com.pojo.Goods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoodsServlet extends HttpServlet {

    private GoodsDAO goodsDAO =  new GoodsDAO();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p = request.getParameter("p");
        if("findall".equals(p)){
            doFindAll(request , response);
        }
        if("findbyid".equals(p)){
            doFindById(request ,response);
        }


    }

    private void doFindById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodsid = request.getParameter("goodsid");
        Goods goods = goodsDAO.findbyid(goodsid);
        request.setAttribute("goods" , goods);
        request.getRequestDispatcher("showDetail.jsp").forward(request , response);





    }

    private void doFindAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Goods> list = goodsDAO.findall();
        request.setAttribute("list" , list);
        request.getRequestDispatcher("show.jsp").forward(request , response);
    }

}
