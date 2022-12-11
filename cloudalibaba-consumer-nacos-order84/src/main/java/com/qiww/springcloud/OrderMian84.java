package com.qiww.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wlq
 * @version 1.0
 * @Email: qiww567@126.com
 * @date 2022/12/10 22:57
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderMian84 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMian84.class, args);
    }
}
