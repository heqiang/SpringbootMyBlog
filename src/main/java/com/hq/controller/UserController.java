package com.hq.controller;

import com.hq.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller

public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping({"/","/index"})
    public String index(){
        return  "index";
    }

    @RequestMapping("/user/login")
    public String login(String username, String password, Model model){
        Map<String,Object>  map = userService.selectByName(username,password);
        String msg = (String) map.get("msg");
        if (msg.equals("ok")){
            model.addAttribute("msg",msg);
            model.addAttribute("user",map.get("user"));
            return "user/success";
        }else {
            model.addAttribute("msg",msg);
            return "index";
        }

    }
    @RequestMapping("/user/register")
    public  String register(){
        return "index";
    }
}
