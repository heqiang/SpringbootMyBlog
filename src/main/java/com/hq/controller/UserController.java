package com.hq.controller;

import com.hq.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping({"/","/index"})
    public String index(){
        return  "index";
    }
    @RequestMapping("/user/toregister")
    public String toregister(){
        return "user/zhuce1";
    }
    @RequestMapping("/user/tologin")
    public String tologin(){
        return  "index";
    }

    @RequestMapping("/user/login")
    public String login(String username, String password, Model model){
        Map<String,Object>  map = userService.login(username,password);
        String msg = (String) map.get("msg");
        if ("ok".equals(msg)){
            model.addAttribute("msg",msg);
            model.addAttribute("user",map.get("user"));
            return "user/success";
        }else {
            model.addAttribute("msg",msg);
            return "index";
        }

    }
    @RequestMapping("/user/register")
    public  String register(String username ,String password,String email,String sex,Model model){
        System.out.println(sex);
        Map<String, Object> map = userService.register(username, password, email, sex);
        String msg = (String) map.get("msg");
        if ("注册成功".equals(msg)){
            model.addAttribute("msg",msg);
            return "index";
        }else {
            model.addAttribute("msg",msg);
            return "user/zhuce1";
        }
    }
}
