package com.qiww.springcloud.service;

/**
 * @author wlq
 * @version 1.0
 * @Email: qiww567@126.com
 * @date 2022/12/6 20:54
 */
public interface PaymentService {
    /**
     * 正常访问的方法
     *
     * @param id
     * @return String
     */
    public String paymentInfoOk(Integer id);

    /**
     * 制造错误的方法（超时、算术异常）
     *
     * @param id
     * @return String
     */
    public String paymentInfoTimeout(Integer id);

    /**
     * HystrixCommand注解中的fallback方法
     *
     * @param id
     * @return String
     */
    public String paymentTimeoutFallbackMethod(Integer id);

    /**
     * 服务熔断测试方法
     *
     * @param id
     * @return String
     */
    public String paymentCircuitBreaker(Integer id);
}
