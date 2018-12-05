package com.ssm.controller.task;


import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 动态设置cron参数
 */
@Lazy(value=false)
@Component
@EnableScheduling
@Controller
public class DynamicCronTask implements SchedulingConfigurer {
    private static Logger log = Logger.getLogger(DynamicCronTask.class);
    public static String cron = "0/10 * * * * ?";

    @RequestMapping("/setDynamicCronTask")
    public String setSpringDynamicCronTask(HttpServletRequest request, String setCron) {
        System.out.println("cron setDynamicCronTaskto:" + setCron);
        cron = setCron;
        System.err.println("cron change to:" + cron);
        return "cron";
    }

    public void configureTasks(ScheduledTaskRegistrar taskRegister) {
        taskRegister.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                // 逻辑任务
                System.out.println("dynamicCronTask is running...");
            }
        }, new Trigger() {

            public Date nextExecutionTime(TriggerContext triggerContext) {
                // 任务触发，可修改任务的执行周期
                CronTrigger trigger = new CronTrigger(cron);
                System.out.println("cron:" + cron);
                Date nextExecutor = trigger.nextExecutionTime(triggerContext);
                return nextExecutor;
            }
        });
    }

}
