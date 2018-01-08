package com.youhuang.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    @Autowired
    public MyBean(ApplicationArguments args) {
        System.out.println("----------->start");
        for (String optionName : args.getOptionNames()) {
            System.out.println(optionName + "=" + args.getOptionValues(optionName).get(0));
        }
        System.out.println("----------->end");
    }
}
