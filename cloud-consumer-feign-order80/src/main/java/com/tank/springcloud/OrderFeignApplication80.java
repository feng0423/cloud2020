package com.tank.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description:
 * @Author: Tank
 * @Date: 2020/3/13 1:07
 * @Version: 1.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients //使用feign
//@RibbonClient(name = "cloud-payment-service", configuration = MySelfRule.class)
public class OrderFeignApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignApplication80.class, args);
    }

}
