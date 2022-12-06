package com.qiww.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wlq
 * @version 1.0
 * @Email: qiww567@126.com
 * @date 2022/12/6 11:27
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8004 {
    /**@EnableDiscoveryClient用于向使用consul或则zookeeper作为注册中心时注册服务**/
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
