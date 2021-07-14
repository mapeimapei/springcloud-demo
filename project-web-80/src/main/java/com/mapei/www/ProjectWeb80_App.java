package com.mapei.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
public class ProjectWeb80_App {

    public static void main(String[] args)
    {
        SpringApplication.run(ProjectWeb80_App.class, args);
    }

}
