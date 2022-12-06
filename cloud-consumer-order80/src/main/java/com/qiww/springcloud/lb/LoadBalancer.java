package com.qiww.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author wlq
 * @version 1.0
 * @Email: qiww567@126.com
 * @date 2022/12/6 16:17
 */
public interface LoadBalancer {
    /**
     * 得到每一个serviceInstance
     * @param serviceInstances
     * @return serviceInstance
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
