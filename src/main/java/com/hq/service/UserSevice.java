package com.hq.service;

import com.hq.pojo.User;

import java.util.Map;

public interface UserSevice {
    Map<String,Object> selectByName(String username,String password);
}
