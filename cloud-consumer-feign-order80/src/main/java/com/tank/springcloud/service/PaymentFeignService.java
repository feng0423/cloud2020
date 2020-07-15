package com.tank.springcloud.service;

import com.tank.springcloud.entities.CommonResult;
import com.tank.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description:
 * @Author: Tank
 * @Date: 2020/3/13 1:07
 * @Version: 1.0
 */
@Component
@FeignClient(value = "cloud-payment-service")//找那个微服务
public interface PaymentFeignService {

    @RequestMapping(value = "payment/get/{id}", method = RequestMethod.GET)
    public CommonResult<Payment> getPaymenyById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}