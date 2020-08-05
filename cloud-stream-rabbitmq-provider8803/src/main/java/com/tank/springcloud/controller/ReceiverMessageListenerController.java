package com.tank.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @desc:
 * @author: Tank
 * @date: 2020/8/4 16:30
 * @Version: 1.0
 */
@Component
@EnableBinding(Sink.class)
public class ReceiverMessageListenerController {

    @Value("${server.port}")
    private  String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("消费者2号， -----> 接受到的消息： " + message.getPayload()
                + "\t port: " + serverPort);
    }
}
