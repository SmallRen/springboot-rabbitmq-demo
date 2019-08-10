package com.smallren.controller;

import com.smallren.entity.User;
import com.smallren.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

/**
 * @Description: user控制器类
 * @Author: renbaojia
 * @CreateDate: 2019/8/8 10:42
 * @UpdateUser:
 * @UpdateDate: 2019/8/8 10:42
 * @UpdateRemark:
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    /**
     * @return List
     */
    @RequestMapping("/select")
    @ResponseBody
    public List<User> select() {
        return userService.select();
    }

    /**
     * @param user
     * @return int
     */
    @RequestMapping("/save")
    @ResponseBody
    public User save(User user) {
        return userService.save(user);
    }
}
