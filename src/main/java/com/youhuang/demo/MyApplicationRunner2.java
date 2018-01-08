package com.youhuang.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Order(value=1)
public class MyApplicationRunner2 implements ApplicationRunner{

    @Autowired
    private MyBean2 myBean2;
    
    @Value("${my.number}")
    private int number;
    
    @Value("${my.name[0]}")
    private String myName;
    
    @Autowired
    private Environment env;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("--->run " + this.getClass() + "<---");
        System.out.println(myBean2.getName());
        System.out.println(number);
        System.out.println(myName);
        System.out.println(env.getProperty("my.profile"));
    }

}
