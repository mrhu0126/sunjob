package com.servlet;

import com.mapper.DepMapper;
import com.pojo.Dep;
import com.util.SqlSessionUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DepServlet extends HttpServlet {

    DepMapper depMapper = SqlSessionUtil.getMapper(DepMapper.class);

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String  p = request.getParameter("p");
        if("findall".equals(p)){
            doFindAll(request  , response);
        }
    }

    private void doFindAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Dep> list = depMapper.findall();

        if(list.size()==0){
            response.getWriter().println("[]");
            return ;
        }

        //  把list集合转换未json
        StringBuffer sb = new StringBuffer("[");
        //  [{"depid":"1" , "depname":"小卖部"},{"depid":"2" , "depname":"宣传部"}]
        for (Dep dep : list) {
            sb.append("{'depid':'").append(dep.getDepid()).append("','depname':'").append(dep.getDepname()).append("'},");
        }

        sb.replace(sb.length()-1 , sb.length() , "]");
        System.out.println(sb);
        response.getWriter().println(sb.toString());

    }
}
