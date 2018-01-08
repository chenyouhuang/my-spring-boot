package com.youhuang.demo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

//@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@PropertySource(value={"classpath:other/application.yml"})
public class DemoConfiguration {

}
