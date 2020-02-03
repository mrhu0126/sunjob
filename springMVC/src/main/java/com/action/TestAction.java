package com.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test.do")
public class TestAction {

    @RequestMapping(params = "p=findall")
    public String findall(){
        return "show.jsp";
    }

}
