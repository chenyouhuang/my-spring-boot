package com.youhuang.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;

public class MyApplication {

    private static final Log logger = LogFactory
            .getLog(MyApplication.class);
    
    public static void main(String[] args) {
        
        System.setProperty("spring.devtools.restart.enabled", "false");
        System.setProperty("spring.main.banner-mode", "off");
        System.setProperty("spring.application.admin.enabled", "true");

        // 启动1
//        SpringApplication.run(DemoConfiguration.class, new String[]{"--debug"});
        
        SpringApplication springApplication = new SpringApplication(MyConfiguration.class);
//        springApplication.addListeners(new ApplicationStartingEvent);
//        springApplication.setWebEnvironment(true);
//        springApplication.setApplicationContextClass(applicationContextClass);
        
//        springApplication.setAddCommandLineProperties(false);
        
        
        springApplication.run(new String[]{
//                "--debug=Test", 
//                "--spring.profiles.active=test"
                });
        
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                logger.info("test----------->");
            }
        }, "1111----------------------->").start();
        
    }
}
