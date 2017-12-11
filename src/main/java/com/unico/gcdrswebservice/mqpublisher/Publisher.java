package com.unico.gcdrswebservice.mqpublisher;

import com.unico.gcdrswebservice.domain.GCD;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * This class is used to publish message to Queue configured
 * @Operations: produceMsg
 * @Developer: Vikas Malviya
 */

@Component
public class Publisher {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${jsa.rabbitmq.exchange}")
    private String exchange;

    public void produceMsg(final GCD gcd){
        System.out.println("sdfsf" );
        amqpTemplate.convertAndSend(exchange, "",gcd);
        System.out.println("Send msg = " + gcd);
    }
}