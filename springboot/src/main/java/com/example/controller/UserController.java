package com.example.controller;

import com.example.pojo.UserInfo;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/testboot")
public class UserController {

    @Autowired
    private UserService userService ;

    @ResponseBody
    @RequestMapping("/findall")
    public List<UserInfo> findall(){
        List<UserInfo> list = userService.findall();
        return list ;
    }


}
