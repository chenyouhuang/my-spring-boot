package com.youhuang.mysqlmulti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SampleMysqlApplication implements CommandLineRunner {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate1;
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println(jdbcTemplate1);
        System.out.println(jdbcTemplate1.queryForObject("SELECT count(*) from user", String.class));
    }

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(DataSourceConfig.class);
        springApplication.setWebEnvironment(false);
        springApplication.run(args).close();
    }
}
