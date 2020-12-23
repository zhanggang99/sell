package com.zg.sell.mail;

import com.zg.sell.domain.User;

import java.util.List;

public interface SendJunkMailService {
    boolean sendJunkMail(List<User> userList);
}
