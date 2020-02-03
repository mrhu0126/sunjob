package com.action;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user.do")
public class UserAction {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(params = "p=fenye")
    public String fenye(){

        String pageString = request.getParameter("page");
        String sizeString = request.getParameter("size");

        int page = 1;
        if(pageString!=null && pageString.trim().length()>0 ){
            page = Integer.parseInt(pageString);
        }
        int size = 4 ;
        if(sizeString!=null && sizeString.trim().length()>0){
            size = Integer.parseInt(sizeString);
        }

        IPage ipage = userService.fenye(page, size);
        request.setAttribute("page" , ipage);
        return "show.jsp";
    }

    @RequestMapping(params = "p=deletebyusername")
    public String deletebyusername(){
       String username = request.getParameter("username");
       int n =  userService.deletebyusername(username);
       return fenye();//重新分页
    }

}
