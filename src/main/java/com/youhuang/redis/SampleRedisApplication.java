package com.youhuang.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class SampleRedisApplication implements CommandLineRunner {

    @Autowired
    private StringRedisTemplate template;
    
    @Override
    public void run(String... args) throws Exception {
        ValueOperations<String, String> ops = template.opsForValue();
        System.out.println(ops.get("1"));
    }

    public static void main(String[] args) {
        
        SpringApplication application = new SpringApplication(SampleRedisConfiguration.class);
        application.setWebEnvironment(false);
        application.run(args).close();
        
//        SpringApplication.run(SampleRedisApplication.class, args).close();
    }
}
