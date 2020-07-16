package com.tank.springcloud.service.impl;

import com.tank.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {
    /**
     * 正常访问 , 肯定Ok方法
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池:  " + Thread.currentThread().getName() + "  paymentInfo_OK,id:  " + id + "\t" + "O(∩_∩)O哈哈~";
    }

    /**
     * 异常访问 , 失败方法
     * @param id
     * @return
     */
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 4 ;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:  " + Thread.currentThread().getName() + "  paymentInfo_TimeOut,id:  " + id + "\t" + "O(∩_∩)O哈哈~" + "耗时(秒):" +timeNumber;
    }
}