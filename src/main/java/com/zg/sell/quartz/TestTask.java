package com.zg.sell.quartz;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestTask {
    private static final Logger logger = LogManager.getLogger(TestTask.class);
    public void run(){
        logger.info("定时器执行了");
    }
}
