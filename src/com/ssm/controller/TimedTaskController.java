package com.ssm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
@Component
public class TimedTaskController {
    private static final Logger log= LoggerFactory.getLogger(TimedTaskController.class);
    //@Scheduled(cron = "0 47 14 ? * *")
    public void test1()
    {
        log.info("job1 开始执行...");

    }
    //@Scheduled(cron = "0/5 * * * * ?")//每隔5秒隔行一次
    public void test2()
    {
        log.info("job2 开始执行");
    }
}

