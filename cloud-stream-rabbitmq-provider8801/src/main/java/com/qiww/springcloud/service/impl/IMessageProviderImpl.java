package com.qiww.springcloud.service.impl;

import com.qiww.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;

/**
 * @author wlq
 * @version 1.0
 * @Email: qiww567@126.com
 * @date 2022/12/9 22:23
 */
@EnableBinding(Source.class)  //定义消息的推送管道
@Slf4j
public class IMessageProviderImpl implements IMessageProvider {
    @Autowired
    private MessageChannel output;  //消息发送的管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("******serial:  " + serial);
        return serial;
    }
}
