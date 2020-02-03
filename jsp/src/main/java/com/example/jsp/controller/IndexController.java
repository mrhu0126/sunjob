package com.example.jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        System.out.println("来了");

        return "index";
    }

}
