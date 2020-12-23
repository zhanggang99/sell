package com.zg.sell.mail;

import com.zg.sell.domain.User;
import com.zg.sell.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
public class SendJunkMailServerImpl implements SendJunkMailService {
    @Autowired
    JavaMailSender mailSender;
    @Resource
    private UserService userService;
    @Value("${spring.mail.username}")
    private String from;
    public static final Logger logger = LogManager.getLogger(SendJunkMailServerImpl.class);

    @Override
    public boolean sendJunkMail(List<User> userList) {
        try {
            if (userList==null || userList.size()<=0)
                return Boolean.FALSE;
            for (User user:userList){
                MimeMessage mimeMessage=this.mailSender.createMimeMessage();
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setFrom(from);
                message.setSubject("张刚的测试邮件");
                message.setTo("zhanggangb@yonyou.com");
                message.setText("你好，这是测试邮件");
                this.mailSender.send(mimeMessage);

            }
        } catch (MessagingException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return false;
    }
}
