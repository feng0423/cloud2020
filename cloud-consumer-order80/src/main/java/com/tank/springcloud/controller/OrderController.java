package com.tank.springcloud.controller;

import com.tank.springcloud.entities.CommonResult;
import com.tank.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: Tank
 * @Date: 2020/3/13 1:07
 * @Version: 1.0
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    private static final String PAYMENT_URL = "http://cloud-payment-service";

    @Autowired
    private DiscoveryClient discoveryClient;

//    @Resource
//    private LoadBalancer loadBalancer;

    @RequestMapping(value = "/consumer/payment/create", method = RequestMethod.POST)
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create", payment, CommonResult.class);
    }

    @RequestMapping(value = "/consumer/payment/get/{id}", method = RequestMethod.GET)
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @RequestMapping(value = "/consumer/payment2/get/{id}", method = RequestMethod.GET)
    public CommonResult<Payment> getPaymentById2(@PathVariable("id")Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        } else {
          return new CommonResult(444,"操作失败") ;
        }
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
