package com.zg.sell.comsumer;

import com.zg.sell.domain.Mood;
import com.zg.sell.service.MoodService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MoodConsumer {
    @JmsListener(destination = "mood.queue")
    public void receiveQueue(String text){
        System.out.println("用户发表说说："+text+"成功");
    }

    @Resource
    private MoodService moodService;
    @JmsListener(destination = "mood.queue.asyn.save")
    public void receiveQueue(Mood mood){
        moodService.save(mood);
    }
}
