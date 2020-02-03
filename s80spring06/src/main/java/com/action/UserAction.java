package com.action;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pojo.UserInfo;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user.do")
public class UserAction {

    @Autowired
    private UserService userService ;

    @Autowired
    private HttpServletRequest request ;

    @RequestMapping(params = "p=findall")
    public String findall(){
        List<UserInfo> list = userService.findall();
        request.setAttribute("list" , list);
        return  "show.jsp";
    }

    @RequestMapping(params = "p=deletebyusername")
    public String deletebyusername(){
        String username = request.getParameter("username");
        userService.deleteByUsername(username);
        return "redirect:user.do?p=findall";
    }

    @RequestMapping(params = "p=fenye")
    public String fenye(){
        IPage ipage = userService.fenye();
        request.setAttribute("ipage" , ipage);
        return "show.jsp";
    }

}
