package com.zg.sell.service.impl;

import com.zg.sell.domain.Mood;
import com.zg.sell.producer.MoodProducer;
import com.zg.sell.service.MoodService;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.sound.midi.Soundbank;

import java.sql.SQLOutput;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MoodServiceImplTest {

    @Resource
    private MoodService moodService;
    @Test
    public void testMood(){
        Mood mood= new Mood("1","这是我的说说","1",0,new Date());
        moodService.save(mood);
    }

    @Resource
    private MoodProducer moodProducer;
    @Test
    public void testActiveMQ(){
        Destination destination=new ActiveMQQueue("mood.queue");
        moodProducer.sendMessage(destination,"hello ，mood mq");
    }

    @Test
    public void testActiveMQAsynSave(){
        Mood mood=new Mood("2","说说2","2",33,new Date());
        String msg = moodService.asynSave(mood);
        System.out.println("异步发表说说："+msg);
    }


}