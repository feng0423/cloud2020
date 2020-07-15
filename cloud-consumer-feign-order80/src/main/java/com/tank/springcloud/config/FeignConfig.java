package com.tank.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Description: 日志配置类
 * @Author: Tank
 * @Date: 2020/7/13 11:38
 * @Version: 1.0
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level FeignLo(){
        return Logger.Level.FULL;
    }
}
