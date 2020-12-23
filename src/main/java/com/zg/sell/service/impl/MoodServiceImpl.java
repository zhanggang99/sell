package com.zg.sell.service.impl;

import com.zg.sell.domain.Mood;
import com.zg.sell.producer.MoodProducer;
import com.zg.sell.repository.MoodRepository;
import com.zg.sell.service.MoodService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

@Service
public class MoodServiceImpl implements MoodService {

    @Resource
    private MoodRepository moodRepository;

    @Override
    public Mood save(Mood mood) {
        return moodRepository.save(mood);
    }

    //列表
    private static Destination destination=new ActiveMQQueue("mood.queue.asyn.save");
    @Resource
    private MoodProducer moodProducer;

    @Override
    public String asynSave(Mood mood) {
        //往队列里推送消息（说说实体）
        moodProducer.sendMessage(destination,mood);
        return "success";
    }
}
