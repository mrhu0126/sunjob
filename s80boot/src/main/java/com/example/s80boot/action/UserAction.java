package com.example.s80boot.action;

import com.example.s80boot.pojo.UserInfo;
import com.example.s80boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/s80boot")
public class UserAction {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/findall")
    public List<UserInfo> findall(){
        List<UserInfo> list = userService.findall();
        return list ;
    }

}
