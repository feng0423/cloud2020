package com.tank.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Description:
 * @Author: Tank
 * @Date: 2020/7/10 21:34
 * @Version: 1.0
 */
public interface LoadBalancer {

    ServiceInstance instances (List<ServiceInstance> serviceInstances);
}
