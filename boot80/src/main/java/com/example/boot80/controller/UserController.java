package com.example.boot80.controller;

import com.example.boot80.pojo.UserInfo;
import com.example.boot80.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/boot80")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody  // 返回的是json
    @RequestMapping("/findall")
    public List<UserInfo> findall(){
        List<UserInfo> list = userService.findall();
        return list ;
    }


}
