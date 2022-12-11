package com.qiww.springcloud.entities.vo;

import lombok.Data;

/**
 * @author SunJiaFan
 * @version 1.0
 * @date 2022/8/21 15:38
 */
@Data
public class OrderVo {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 产品id
     */
    private Integer productId;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 金额
     */
    private Integer money;
    private Integer success;
}
