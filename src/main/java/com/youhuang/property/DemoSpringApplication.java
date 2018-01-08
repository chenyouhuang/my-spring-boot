package com.youhuang.property;

import org.springframework.boot.SpringApplication;

public class DemoSpringApplication {

    public static void main(String[] args) {
        
        SpringApplication springApplication = new SpringApplication(DemoConfiguration.class);
        
        springApplication.run(new String[]{
                });
        
    }
}
