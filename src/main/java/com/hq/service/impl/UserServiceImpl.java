package com.hq.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hq.mapper.UserMapper;
import com.hq.pojo.User;
import com.hq.service.UserSevice;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserSevice {
    @Autowired
    private UserMapper userMapper;

    /*
    *
    * 登录逻辑
    * */
    @Override
    public Map<String,Object> selectByName(String username,String password) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",username);
        User user = userMapper.selectOne(queryWrapper);
        System.out.printf(username);
        HashMap<String, Object> map = new HashMap<>();
        if(user==null){
            map.put("msg","用户不存在");

        }else {
            if(user.getPassword().equals(password)){
                map.put("msg","ok");
                map.put("user",user);
            }else {
                map.put("msg","密码错误");
            }
        }
        return map;

    }
}
