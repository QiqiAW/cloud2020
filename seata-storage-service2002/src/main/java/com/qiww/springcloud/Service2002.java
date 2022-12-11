package com.qiww.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.qiww.springcloud.mapper")
@EnableFeignClients
@EnableDiscoveryClient
public class Service2002 {
    public static void main(String[] args) {
        SpringApplication.run(Service2002.class,args);
        System.out.println("Hello world!");
    }
}
