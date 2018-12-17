package com.ssm.controller;

import com.ssm.service.impl.commodityExport;
import com.ssm.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Date;

/**
 *
 * 类名称：TimerTask   
 * 类描述：定时器任务
 * 创建人：hu
 * 创建时间：12.13, 2018 10:56:27 AM
 * @version  V1.0
 *
 */
@Component
@Controller
public class TimerTask {
    private static Logger log = LoggerFactory.getLogger(TimerTask.class);
    @Resource
    commodityExport comm=null;

    /**
     * 每天凌晨1点执行一次
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void test2()
    {
        try {
            log.info("导出文件 开始执行"+ DateUtil.dateToString(new Date(), "yyyy-MM-dd"));
            comm.OuteXlsx("zbw_plantkc");
            log.info("导出成功"+ DateUtil.dateToString(new Date(), "yyyy-MM-dd"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 表示在每月的1日的凌晨2点调度任务
     */
    @Scheduled(cron = "0 0 2 1 * ?")
    public void test1() {
        try {
            log.info("导出文件 开始执行"+ DateUtil.dateToString(new Date(), "yyyy-MM-dd"));
            comm.OuteXlsx("zbw_storekc");
            log.info("导出成功"+ DateUtil.dateToString(new Date(), "yyyy-MM-dd"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
