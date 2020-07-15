package com.tank.springcloud.controller;

import com.tank.springcloud.entities.CommonResult;
import com.tank.springcloud.entities.Payment;
import com.tank.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: Tank
 * @Date: 2020/3/13 1:07
 * @Version: 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPost;

    @RequestMapping(value = "/payment/create", method = RequestMethod.POST)
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入成功,使用端口为: "+serverPost, result);
        } else {
            return new CommonResult(444, "插入失败", null);
        }
    }

    @RequestMapping(value = "/payment/get/{id}", method = RequestMethod.GET)
    public CommonResult getPaymentById(@PathVariable("id")Long id) {
        Payment payment = paymentService.getPaymentById(id);

        log.info("查询结果：" + payment );

        if (payment != null) {
            return new CommonResult(200, "查询成功,使用端口为: "+serverPost, payment);
        } else {
            return new CommonResult(444, "查询失败" , null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPost;
    }
}
