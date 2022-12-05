package com.qiww.springcloud.service;

import com.qiww.springcloud.entities.Payment;

/**
 * @author wlq
 * @version 1.0
 * @Email: qiww567@126.com
 * @date 2022/12/2 15:24
 */
public interface PaymentService {
    /**
     * 获取总数
     * @param payment
     * @return
     */
    public int create(Payment payment);

    /**
     * 通过ID获取Payment
     * @param id
     * @return
     */
    public Payment getPaymentById(Long id);
}
