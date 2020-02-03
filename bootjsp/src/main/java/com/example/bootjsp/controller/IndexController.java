package com.example.bootjsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bootjsp")
public class IndexController {

    @RequestMapping("/a")
    public String index(){
        System.out.println("来了");
        return "index";
    }


}
