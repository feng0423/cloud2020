package com.tank.springcloud.controller;

import com.tank.springcloud.entities.CommonResult;
import com.tank.springcloud.entities.Payment;
import com.tank.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
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
public class OrderFeignController {


    @Resource
    private PaymentFeignService paymentFeignService;

//    @Autowired
//    private DiscoveryClient discoveryClient;
//
//    @Resource
//    private LoadBalancer loadBalancer;

    @RequestMapping(value = "/consumer/payment/get/{id}", method = RequestMethod.GET)
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id) {
        return paymentFeignService.getPaymenyById(id);
    }

    @GetMapping(value = "consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //open-feign-ribbon 客户端一般默认等待一秒钟
        return paymentFeignService.paymentFeignTimeout();
    }

//    @GetMapping("/consumer/payment/lb")
//    public String getPaymentLB() {
//        // 通过容器中的 discoveryClient和服务名来获取服务集群
//        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
//        if(instances == null || instances.size() <= 0) {
//            return null;
//        }
//        // 传入服务集群来计算出获取具体的服务实例
//        ServiceInstance serviceInstance = loadBalancer.instances(instances);
//        URI uri = serviceInstance.getUri();
//        return  restTemplate.getForObject(uri+"/payment/lb",String.class);
//    }

}
