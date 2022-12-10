package com.qiww.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.qiww.springcloud.entities.CommonResult;

/**
 * @author wlq
 * @version 1.0
 * @Email: qiww567@126.com
 * @date 2022/12/10 22:22
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(444, "按客户自定义，global handlerException----1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(444, "按客户自定义，global handlerException----2");
    }
}
