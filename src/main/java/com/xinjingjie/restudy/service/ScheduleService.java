package com.xinjingjie.restudy.service;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    /*
    "0 * * * * MON-FRI"
     */
    @Scheduled(cron = "0-4 * * * * SUN-MON")
    public void scheduleDid(){
        System.out.println("hello!");
    }
}
