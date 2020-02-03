package com.example.layui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui")
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

}
