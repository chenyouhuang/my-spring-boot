package com.youhuang.mysqlmulti;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="spring.datasource.primary")
public class DataSourceProperties1 {

    private String url;
    
    private String username;
    
    private String password;
    
    private String DriverClassName;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return DriverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        DriverClassName = driverClassName;
    }
    
}
