package com.zg.sell.service;

import com.zg.sell.domain.Mood;
//保存说说的接口
public interface MoodService {
    Mood save(Mood mood);
    String asynSave(Mood mood);
}
