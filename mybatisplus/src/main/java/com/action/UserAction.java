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
    private UserService userService ;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(params = "p=fenye")
    public String fenye(){
        IPage iPage = userService.fenye();
        request.setAttribute("ipage" , iPage );
        return "show.jsp" ;
    }

}
