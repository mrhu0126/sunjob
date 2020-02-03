package com.servlet;

import com.dao.UserDAO;
import com.pojo.Goods;
import com.pojo.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {

    private UserDAO userDAO = new UserDAO();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html;charset=utf-8");
        String p = request.getParameter("p");
        if ("login".equals(p)) {
            doLogin(request, response);
        }

        if("addCollection".equals(p)){
            doAddCollection(request ,response);
        }

        if("findcollection".equals(p)){
            doFindCollection(request ,response);
        }

    }

    //查找收藏
    private void doFindCollection(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");

        String username = userInfo.getUsername();
        List<Goods> list = userDAO.findCollection(username);
        request.setAttribute("list" , list);
        request.getRequestDispatcher("showCollection.jsp").forward(request ,response);

    }

    //加入收藏
    private void doAddCollection(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //先得到session
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");

        if(userInfo==null){
            response.getWriter().println("<script>alert('请登录先');location='login.jsp';</script>");
            return ;
        }
        String goodsid = request.getParameter("goodsid");
        String username = userInfo.getUsername();
        boolean f = userDAO.check(username , goodsid);
        if(f){// 收藏了
            response.getWriter().println("<script>alert('您已经收藏！');location='goods.do?p=findbyid&goodsid="+goodsid+"';</script>");
            return ;
        }
        //收藏
        int n = userDAO.addCollection(username , goodsid);
        if(n>0){
            response.getWriter().println("<script>alert('收藏成功！');location='goods.do?p=findbyid&goodsid="+goodsid+"';</script>");

        }


    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserInfo userInfo = userDAO.login(username, password);

        if(userInfo==null){
            response.getWriter().println("<script>alert('用户名或密码错误'!);location='login.jsp';</script>");
            return ;
        }

        //如果登录成功
        HttpSession session = request.getSession();
        session.setAttribute("userinfo" , userInfo);
        request.getRequestDispatcher("goods.do?p=findall");

    }
}
