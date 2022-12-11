package com.qiww.springcloud.controller;

import com.qiww.springcloud.entities.CommonResult;
import com.qiww.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author wlq
 * @version 1.0
 * @Email: qiww567@126.com
 * @date 2022/12/10 22:40
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();
    static {
        hashMap.put(1L, new Payment(1L, "1sdfdfdfasfdafafdasf"));
        hashMap.put(2L, new Payment(2L, "2sdfdfdfasfdafafdasf"));
        hashMap.put(3L, new Payment(3L, "3sdfdfdfasfdafafdasf"));
    }

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<>(200, "from mysql,serverPort:  " + serverPort, payment);
        return result;
    }
}
