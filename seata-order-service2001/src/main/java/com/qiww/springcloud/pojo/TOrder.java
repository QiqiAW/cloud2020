package com.qiww.springcloud.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


@TableName("t_order")
@Data
public class TOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

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

    /**
     * 0创建1已完结
     */
    private Integer status;


    @Override
    public String toString() {
        return "TOrder{" +
            "id=" + id +
            ", userId=" + userId +
            ", productId=" + productId +
            ", count=" + count +
            ", money=" + money +
            ", status=" + status +
        "}";
    }
}
