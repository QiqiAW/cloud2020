package com.qiww.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author wlq
 * @version 1.0
 * @Email: qiww567@126.com
 * @date 2022/12/8 16:18
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfoOk(Integer id) {
        return "-------PaymentFallbackService fallback paymentInfoOK, sssss";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "-------PaymentFallbackService fallback paymentInfoTimeout, sssss";
    }

    @Override
    public String paymentCircuitBreaker(Integer id) {
        return "-------PaymentFallbackService fallback paymentCircuitBreaker, sssss";
    }
}
