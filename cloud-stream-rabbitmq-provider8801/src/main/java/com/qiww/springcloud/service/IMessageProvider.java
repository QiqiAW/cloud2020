package com.qiww.springcloud.service;

/**
 * @author wlq
 * @version 1.0
 * @Email: qiww567@126.com
 * @date 2022/12/9 22:21
 */
public interface IMessageProvider {
    /**
     * 消息的发送
     *
     * @return String
     */
    public String send();
}
