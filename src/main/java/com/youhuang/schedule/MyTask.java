package com.youhuang.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTask {

    @Scheduled(fixedDelay=1*1000)
    public void test(){
        System.out.println("----->1");
    }
}
