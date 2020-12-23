package com.zg.sell.quartz;

import com.zg.sell.domain.User;
import com.zg.sell.mail.SendJunkMailService;
import com.zg.sell.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Configurable
@EnableScheduling
public class SendMailQuartz {
    private static final Logger logger = LogManager.getLogger(SendMailQuartz.class);
    @Autowired
    private UserService userService;
    @Autowired
    private SendJunkMailService sendJunkMailService;
    //每5秒执行一次
    @Scheduled(cron="*/5 * * * * *")
    public void reportCurrentByCron(){
        logger.info("每5秒执行一次。。。1");
        List<User> userList=userService.findAll();
        if (userList==null || userList.size()<=0)
            return;
        //sendJunkMailService.sendJunkMail(userList);  避免一直发邮件
        logger.info("每5秒执行一次。。。2");
    }
}
