package com.qiww.springcloud.dao;

import com.qiww.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wlq
 * @version 1.0
 * @Email: qiww567@126.com
 * @date 2022/12/2 14:25
 */
@Mapper
public interface PaymentDao {
    /**
     * 获取总数
     * @param payment
     * @return int
     */
    public int create(Payment payment);

    /**
     * 通过ID获取Payment
     * @param id
     * @return Payment
     */
    public Payment getPaymentById(@Param("id") Long id);
}
