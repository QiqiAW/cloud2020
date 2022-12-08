package com.qiww.springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.qiww.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author wlq
 * @version 1.0
 * @Email: qiww567@126.com
 * @date 2022/12/6 20:55
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "  paymentInfoOk,id: " + id + "\t" + "xxxxxxxx";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentTimeoutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfoTimeout(Integer id) {
//        int i = 10 / 0;
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "  paymentInfoTimeout,id: " + id + "\t" + "yyyyyyy耗时3秒";
    }

    @Override
    public String paymentTimeoutFallbackMethod(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "  系统繁忙或运行报错，请稍后再试,id: " + id + "\t" + "ssssss";
    }
}
