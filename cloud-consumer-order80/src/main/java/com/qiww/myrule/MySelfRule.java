package com.qiww.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wlq
 * @version 1.0
 * @Email: qiww567@126.com
 * @date 2022/12/6 15:46
 */
@Configuration
public class MySelfRule {
    /**
     * 切换为随机负载均衡
     * @return randomRule
     */
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
