package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author siji
 * @date 2019/9/18
 */
@MapperScan("com.example.mapper")
@SpringBootApplication

public class TcesApplication {

    public static void main(String[] args) {
        SpringApplication.run(TcesApplication.class, args);
    }
}
