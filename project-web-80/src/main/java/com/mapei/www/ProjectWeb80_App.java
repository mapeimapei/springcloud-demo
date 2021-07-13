package com.mapei.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ProjectWeb80_App {

    public static void main(String[] args)
    {
        SpringApplication.run(ProjectWeb80_App.class, args);
    }

}
