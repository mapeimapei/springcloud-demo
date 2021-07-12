package com.mapei.www;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.mapei.www.dao"})
public class UserProvider8001_App {

    public static void main(String[] args) {
        SpringApplication.run(UserProvider8001_App.class, args);
    }



}
