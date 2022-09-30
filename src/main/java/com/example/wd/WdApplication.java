package com.example.wd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.wd.mapper")
public class WdApplication {

    public static void main(String[] args) {
        SpringApplication.run(WdApplication.class, args);
    }

}
