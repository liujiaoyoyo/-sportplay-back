package com.naughty.userlogin02.controller;

import com.alibaba.fastjson.JSON;
import com.naughty.userlogin02.bean.User;
import com.naughty.userlogin02.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {
    @Autowired
    UserDao userDao;
    @RequestMapping("/test")
    public String userLogin() {

        return "yoyogood";
    }

    @CrossOrigin
    @RequestMapping("/login")
    public String userLogin(@RequestBody User user) {
        System.out.println("User : " + user);
        String flag = "error";
        HashMap<String,Object> res=new HashMap<>();
        User user1= userDao.getUserByMassage(user.getUsername(), user.getPassword());
        if(user1!=null) {
            System.out.println(user1);
            flag="ok";

        }
        res.put("flag",flag);
        res.put("user",user1);
        String res_json=JSON.toJSONString(res);
        return res_json;
    }
}
