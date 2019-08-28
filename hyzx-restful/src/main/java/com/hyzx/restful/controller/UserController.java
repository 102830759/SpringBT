package com.hyzx.restful.controller;

import com.hyzx.restful.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huyue
 * @date 2019/8/28 17:15
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/get")
    public User get(){
        User user= new User();
        user.setName("张三");
        user.setAge("26");
        return user;
    }
}
