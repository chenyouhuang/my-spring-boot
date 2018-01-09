package com.youhuang.mysqlmulti;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableConfigurationProperties({DataSourceProperties1.class, DataSourceProperties2.class})
public class DataSourceConfig {

    @Autowired
    private DataSourceProperties1 dataSourceProperties1;
    
    @Autowired
    private DataSourceProperties1 dataSourceProperties2;
    
    @Primary
    @Bean(name="primaryDataSource")
    public DataSource primaryDataSource(Environment env) {
        DataSource dataSource = DataSourceBuilder.create()
                .url(dataSourceProperties1.getUrl())
                .username(dataSourceProperties1.getUsername())
                .password(dataSourceProperties1.getPassword())
                .driverClassName(dataSourceProperties1.getDriverClassName()).build();
        System.out.println(dataSource);
        return dataSource;
    }
    
    @Bean(name="secondaryDataSource")
    public DataSource secondaryDataSource() {
        DataSource dataSource = DataSourceBuilder.create()
                .url(dataSourceProperties2.getUrl())
                .username(dataSourceProperties2.getUsername())
                .password(dataSourceProperties2.getPassword())
                .driverClassName(dataSourceProperties2.getDriverClassName()).build();
        System.out.println(dataSource);
        return dataSource;
    }
    
    @Bean(name="primaryJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(
            @Autowired@Qualifier("primaryDataSource")DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    
    @Bean(name="secondaryJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(
            @Autowired@Qualifier("secondaryDataSource")DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
