/**
 * 
 */
package com.iStudy.springboot.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ftchen
 *
 */
@Component
public class RabbitMQProducer {
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	public void send(String queueName){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("email", "756840349@qq.com");
        map.put("timestamp", System.currentTimeMillis());
        String jsonString = map.toString();
        // 生产者发送消息的时候需要设置消息id
        Message message = MessageBuilder.withBody(jsonString.getBytes())
                .setDeliveryMode(MessageDeliveryMode.PERSISTENT)
                .setContentType(MessageProperties.CONTENT_TYPE_JSON).setContentEncoding("utf-8")
                .build();
        rabbitTemplate.convertAndSend(queueName, message);
    }
	
}
