package com.youhuang.runner;

import java.util.Arrays;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value=4)
public class MyCommandLineRunnerOfPrintBeans implements CommandLineRunner {

    @Autowired
    private ApplicationContext applicationContext;
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println("--->run " + this.getClass() + " start...<---");
        
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        
        System.out.println("--->run " + this.getClass() + " end...<---");
    }


}
