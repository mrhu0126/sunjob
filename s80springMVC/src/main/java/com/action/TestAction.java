package com.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test.do")//  请求带什么参数会执行该Action
public class TestAction {

    @RequestMapping(params = "p=findall")
    public String test(){
        //return "show.jsp";//转发到show.jsp
        return "redirect:show.jsp";
    }

}
