package com.tank.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: Tank
 * @Date: 2020/3/13 1:07
 * @Version: 1.0
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class OrderConsulApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulApplication80.class, args);
    }

}
