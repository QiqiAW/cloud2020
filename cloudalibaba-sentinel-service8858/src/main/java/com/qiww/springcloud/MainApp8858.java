package com.qiww.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wlq
 * @version 1.0
 * @Email: qiww567@126.com
 * @date 2022/12/10 18:32
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MainApp8858 {
    public static void main(String[] args) {
        SpringApplication.run(MainApp8858.class, args);
    }
}
