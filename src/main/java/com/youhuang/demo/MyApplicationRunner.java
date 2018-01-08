package com.youhuang.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value=0) // 值小的优先级高，先执行
public class MyApplicationRunner implements ApplicationRunner{

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("--->run " + this.getClass() + "<---");
        
        System.out.println("local.server.port:" + System.getProperty("local.server.port"));
    }

}
