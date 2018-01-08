package com.youhuang.demo;

import java.util.Map.Entry;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
@Order(value=3)
public class MyApplicationRunnerOfPrintProperties implements ApplicationRunner{

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("--->run " + this.getClass() + "<---");
        
        for (Entry<Object, Object> entry : System.getProperties().entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

}
