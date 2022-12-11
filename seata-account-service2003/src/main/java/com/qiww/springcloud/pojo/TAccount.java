package com.qiww.springcloud.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 */
@TableName("t_account")
@Data
public class TAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 总额度
     */
    private Integer total;

    /**
     * 使用额度
     */
    private Integer used;

    /**
     * 剩余额度
     */
    private Integer residue;

    @Override
    public String toString() {
        return "TAccount{" +
            "id=" + id +
            ", userId=" + userId +
            ", total=" + total +
            ", used=" + used +
            ", residue=" + residue +
        "}";
    }
}
