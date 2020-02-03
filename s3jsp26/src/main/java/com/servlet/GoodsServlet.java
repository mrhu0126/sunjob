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

    private GoodsDAO goodsDAO = new GoodsDAO();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html;charset=utf-8");
        String p = request.getParameter("p");
        if("findbykind".equals(p)){
            doFindByKind(request , response);
        }

    }

    private void doFindByKind(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Goods> list = goodsDAO.findbykind();

        if(list.size()==0){
            response.getWriter().println("[]");
            return ;
        }

        StringBuffer sb = new StringBuffer("[");

        for (Goods goods : list) {
            sb.append("{'goodsid':'").append(goods.getGoodsid()).append("','goodsname':'").append(goods.getGoodsname()).append("','goodsprice':'").append(goods.getGoodsprice()).append("','goodspic':'").append(goods.getGoodspic()).append("','goodsdesc':'").append(goods.getGoodsdesc()).append("','goodscount':'").append(goods.getGoodscount()).append("'},");
        }

        sb.replace(sb.length()-1 , sb.length() , "]");
        System.out.println(sb.toString());
        response.getWriter().println(sb.toString());





    }
}
