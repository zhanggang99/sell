package com.zg.sell.controller;

import com.zg.sell.domain.User;
import com.zg.sell.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/User")
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/test")
    public String test(Model model){
        List<User> list=userService.findAll();
        model.addAttribute("users",list);
        return "user";
    }
}
