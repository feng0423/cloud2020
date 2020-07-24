package com.tank.springcloud.controller;

import com.tank.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/payment/hystrix/ok/{id}", method = RequestMethod.GET)
    public String paymentInfo_OK(@PathVariable("id")Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        log.info("查询结果：" + result);
        return result;
    }

    @RequestMapping(value = "/payment/hystrix/timeOut/{id}", method = RequestMethod.GET)
    public String paymentInfo_TimeOut(@PathVariable("id")Integer id) {
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("查询结果：" + result);
        return result;
    }

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*****result: " + result);
        return result;
    }
//    @GetMapping(value = "/payment/discovery")
//    public Object discovery(){
//        //获取服务列表
//        List<String> services = discoveryClient.getServices();
//        for (String service : services) {
//            log.info("*****element:" + service);
//        }
//        //获取某个服务下的集群列表
//        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
//        for (ServiceInstance instance : instances) {
//            log.info(instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
//        }
//        return this.discoveryClient;
//    }
//
//    @GetMapping(value = "/payment/lb")
//    public String getPaymentLB(){
//        return serverPost;
//    }
//
//
//    @GetMapping(value = "/payment/feign/timeout")
//    public String paymentFeignTimeout(){
//        try {
//            TimeUnit.SECONDS.sleep(4);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return serverPost;
//    }

}
