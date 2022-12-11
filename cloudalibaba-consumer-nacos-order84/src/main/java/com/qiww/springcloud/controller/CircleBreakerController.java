package com.qiww.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.qiww.springcloud.entities.CommonResult;
import com.qiww.springcloud.entities.Payment;
import com.qiww.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wlq
 * @version 1.0
 * @Email: qiww567@126.com
 * @date 2022/12/10 22:59
 */
@RestController
@Slf4j
public class CircleBreakerController {
    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")
//    @SentinelResource(value = "fallback",fallback = "handlerFallback")
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler")
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
        CommonResult result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException，非法参数异常----");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException，改id没有对应记录----");
        }
        return result;
    }

    /**
     * 为了上面方法的@SentinelResource 的 fallback配置
     *
     * @param id
     * @param e
     * @return CommonResult
     */
    public CommonResult handlerFallback(@PathVariable("id") Long id, Throwable e) {
        Payment payment = new Payment(id, null);
        return new CommonResult(444, "兜底异常handlerFallback,exception内容    " + e.getMessage(), payment);
    }

    /**
     * 为了上面方法的@SentinelResource 的 blockHandler配置
     *
     * @param id
     * @param e
     * @return CommonResult
     */
    public CommonResult blockHandler(@PathVariable("id") Long id, BlockException e) {
        Payment payment = new Payment(id, null);
        return new CommonResult(445, "blockHandler-sentinel限流，无此流水,blockException内容    " + e.getMessage(), payment);
    }

//    =========OpenFeign

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        return paymentService.paymentSQL(id);
    }
}
