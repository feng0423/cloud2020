package com.tank.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Description:
 * @Author: Tank
 * @Date: 2020/3/13 1:07
 * @Version: 1.0
 */
@SpringBootApplication
@EnableHystrixDashboard
public class OrderHystrixDashboardApplication9001 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixDashboardApplication9001.class,args);
    }

}
