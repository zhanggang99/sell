package com.zg.sell.controller;

import com.zg.sell.domain.User;
import com.zg.sell.error.BusinessException;
import com.zg.sell.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/adduser")
    public String addUser(){
        return "adduser";
    }
    @RequestMapping("/save")
    public String save(User user){
        System.out.println(user);
        return "/save";
    }


//    处理参数：
//    @PatchVariable：获取url中的数据
//    @RequestParam：获取请求参数的值
//    @GetMapping：组合注解

    //http://localhost:8080/user/say/33

    //http://localhost:8080/user/say?id=44
    @GetMapping(value = "/say/{id}")
    public String say(@PathVariable("id") Integer id){
        System.out.println("ID="+id);
        return "save";
    }

}

//记录：
//2.命令启动 mvn spring-boot:run
//        3.  mvn install    再：cd target  后：java -jar xx.jar启动。
//
//@Controller :处理http请求
//@RestController:SPring4后添加的注解，原来返回json需要@ResponseBody配合@controller
//@RequestMapping:配置url映射
//
//@Controller要使用模板：spring-boot-starter-thymeleaf
//
//
//
//        希望访问/hello或/hi都能打开相同页面。@RequestMapping(value={“/hello”,”/hi”},method=RequestMethod.GET)
