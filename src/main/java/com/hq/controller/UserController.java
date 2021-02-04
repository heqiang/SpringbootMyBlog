package com.hq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class UserController {
    @RequestMapping({"/","/index"})
    public String index(){
        return  "index";
    }

    @RequestMapping("/user/login")
    public String login(){
        return "user/success";
    }
    @RequestMapping("/user/register")
    public  String register(){
        return "index";
    }
}
