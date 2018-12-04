package com.ssm.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
@Component
public class TimedTaskController {

    //@Scheduled(cron = "0 47 14 ? * *")
    public void test1()
    {
        System.out.println("job1 开始执行...");
    }
   // @Scheduled(cron = "0/5 * * * * ?")//每隔5秒隔行一次
    public void test2()
    {
        System.out.println("job2 开始执行");
    }
}

