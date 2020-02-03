package com.example.jsps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("jsps")
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        System.out.println("aaa");
        return "index";
    }

}
