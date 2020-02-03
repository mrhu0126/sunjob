package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("index")
public class IndexAction {

    @RequestMapping("/index")
    public String test(){
        return "index";
    }

}
