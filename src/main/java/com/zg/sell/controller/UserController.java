package com.zg.sell.controller;

import com.zg.sell.domain.User;
import com.zg.sell.error.BusinessException;
import com.zg.sell.service.UserService;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/test")
    public String test(Model model){
        List<User> list=userService.findAll();
        model.addAttribute("users",list);
        return "user";
    }


    @RequestMapping("/findall")
    public String findAll(Model model){
        List<User> userList=userService.findAll();
        model.addAttribute("users",userList);
        throw new BusinessException("Findall 业务异常");
    }

    @RequestMapping("/findRetry")
    public String findByNameAndPasswordRetryTest(Model model){
        User user=userService.findByNameAndPasswordRetry("zt","222");
        model.addAttribute("user",user);
        return "success";
    }
}
