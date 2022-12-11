package com.qiww.springcloud.service;

import com.qiww.springcloud.entities.CommonResult;
import com.qiww.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author wlq
 * @version 1.0
 * @Email: qiww567@126.com
 * @date 2022/12/11 12:07
 */
@Component
public class PaymentFallbackService implements PaymentService{

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444, "服务降级返回，-----PaymentFallbackService", new Payment(id, "errorSerial"));
    }
}
