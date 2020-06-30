package com.tank.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * @Description:
 * @Author: Tank
 * @Date: 2020/3/15 20:15
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication7003 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication7003.class, args);
    }
}

