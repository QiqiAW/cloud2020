package com.qiww.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wlq
 * @version 1.0
 * @Email: qiww567@126.com
 * @date 2022/12/9 16:57
 */
@SpringBootApplication
@EnableEurekaClient
public class MainAppConfigClient3355 {
    public static void main(String[] args) {
        SpringApplication.run(MainAppConfigClient3355.class, args);
    }
}
