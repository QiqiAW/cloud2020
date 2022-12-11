package com.qiww.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.qiww.springcloud.mapper")
@SpringBootApplication
public class Service2003 {
    public static void main(String[] args) {
        SpringApplication.run(Service2003.class,args);
        System.out.println("Hello world!");
    }
}
