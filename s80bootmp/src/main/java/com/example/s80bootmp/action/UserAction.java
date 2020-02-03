package com.example.s80bootmp.action;

import com.example.s80bootmp.pojo.UserInfo;
import com.example.s80bootmp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import java.util.List;

@RestController
@RequestMapping("bootmp")
public class UserAction {

    @Autowired
    private UserService userService ;


    @ResponseBody
    @RequestMapping("findall")
    public List<UserInfo> findall(){
        List<UserInfo> list = userService.findall();
        return list ;
    }


}
