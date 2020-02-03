package com.servlet;

import com.dao.GoodsDAO;
import com.dao.PictureDAO;
import com.pojo.Goods;
import com.pojo.Picture;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GoodsServlet extends HttpServlet {

    private GoodsDAO goodsDAO = new GoodsDAO();
    private PictureDAO pictureDAO = new PictureDAO();


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String p = request.getParameter("p");

        if ("fenye".equals(p)) {
            doFenYe(request, response);
        }

        if ("findbyid".equals(p)) {
            doFindById(request, response);
        }

        if("addCar".equals(p)){
            doAddCar(request ,response);
        }

    }

    //加入购物车
    private void doAddCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodsid = request.getParameter("goodsid");
        String numString = request.getParameter("num");

        //得到session
        HttpSession session = request.getSession();
        Map<Goods , Integer> map = (Map<Goods, Integer>) session.getAttribute("map");

        if(map==null){
            map = new HashMap<Goods , Integer>();
        }
        //商品对象作为键
        Goods goods = goodsDAO.findbyid(goodsid);


        Integer integer = map.get(goods);

        if(integer==null){
            map.put(goods , Integer.parseInt(numString));
        }else{
            map.put(goods , Integer.parseInt(numString) + integer);
        }

        session.setAttribute("map" , map);
        //request.getRequestDispatcher("showCar.jsp").forward(request , response);
        response.sendRedirect("showCar.jsp");


    }

    //根据主键查找
    private void doFindById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodsid = request.getParameter("goodsid");
        Goods goods = goodsDAO.findbyid(goodsid);//根据主键查找商品
        //根据商品查找商品图片
        Set<Picture> set = pictureDAO.findbygid(goodsid);
        goods.setPics(set);
        request.setAttribute("goods", goods);
        request.getRequestDispatcher("showDetail.jsp").forward(request, response);
    }

    //分页
    private void doFenYe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        int size = 4;

        String pageString = request.getParameter("page");
        String sizeString = request.getParameter("size");

        if (pageString != null && pageString.trim().length() > 0) {
            page = Integer.parseInt(pageString);
        }

        if (sizeString != null && sizeString.length() > 0) {
            size = Integer.parseInt(sizeString);
        }



        String name = request.getParameter("name");
        String bottom = request.getParameter("bottom");
        String top = request.getParameter("top");

        //求总页数
        int count = goodsDAO.getCount(name , bottom ,top);
        int pageCount = count % size == 0 ? count / size : count / size + 1;

        if (page > pageCount) {
            page = pageCount;
        }

        if (page < 1) {
            page = 1;
        }

        List<Goods> list = goodsDAO.fenye(page, size,name , bottom, top);


        Map map = new HashMap();
        map.put("list", list);
        map.put("page", page);
        map.put("size", size);
        map.put("count", count);
        map.put("pageCount", pageCount);
        map.put("name", name);
        map.put("bottom", bottom);
        map.put("top" , top);

        request.setAttribute("map", map);
        request.getRequestDispatcher("show.jsp").forward(request, response);
    }
}
