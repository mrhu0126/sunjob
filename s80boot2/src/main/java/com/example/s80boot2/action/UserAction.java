package com.example.s80boot2.action;

import com.example.s80boot2.pojo.UserInfo;
import com.example.s80boot2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/boot")
public class UserAction {

    @Autowired
    private UserService userService ;

    @ResponseBody
    @RequestMapping("/findall")
    public List<UserInfo> findall(){
        List<UserInfo> list = userService.findall();
        return list ;
    }

    @Autowired
    private HttpServletRequest request ;

    @ResponseBody
    @RequestMapping("/delbyid")
    public int delbyid(){
        String username = request.getParameter("username");
        int n = userService.delbyid(username);
        return n ;
    }
}
