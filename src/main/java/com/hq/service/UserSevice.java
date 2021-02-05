package com.hq.service;

import com.hq.pojo.User;

import java.util.Map;

public interface UserSevice {
    Map<String,Object> login(String username,String password);
    Map<String,Object> register(String username,String password,String email,String sex);

}
