package com.youhuang.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.youhuang.property.configurationProperties.FooProperties;
import com.youhuang.runner.MyCommandLineRunnerOfPrintBeans;

//@SpringBootApplication
@ComponentScan(basePackages={"com.youhuang.property", "com.youhuang.runner"},
    includeFilters={@Filter(type=FilterType.ASSIGNABLE_TYPE, classes={MyCommandLineRunnerOfPrintBeans.class})},
    excludeFilters={@Filter(type=FilterType.ASSIGNABLE_TYPE, classes={ApplicationRunner.class})})
@EnableAutoConfiguration
@PropertySource(value={
        "classpath:other/application.yml",
        "classpath:other/foo.properties"})
@EnableConfigurationProperties(FooProperties.class)
public class DemoConfiguration implements CommandLineRunner {
    
    @Value("${my.number}")
    private int number;
    
    @Value("${othername}")
    private String name;
    
    @Autowired
    private Environment env;
    
    @Autowired
    private FooProperties fooProperties;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(number);
        System.out.println(name);
        System.out.println(env.getProperty("my.othername"));
//        System.out.println(env.getRequiredProperty("my.othername"));
        
        System.out.println(fooProperties);
    }

}
