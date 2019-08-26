package com.vince.myblog.service.Quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: myblog
 * @author: Dong Ping
 * @description: 定时任务
 * @create: 2019-08-22 15:48
 */
@Service
public class QuartzService {
    @Scheduled(cron = "0 0/1 * * * ?")
//    @Scheduled(cron = "0/2 * * * * *")
    public void timerToNow(){
        System.out.println("now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
