/**
 * 
 */
package com.iStudy.springboot.service.impl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author ftchen
 * 
 */
@Component
public class RabbitMQConsumer {

	@RabbitListener(queues = "test_queue")
	public void consumeMessage(Message message) throws Exception{
		String msg = new String(message.getBody(), "UTF-8");
		System.out.println("消费消息：" + msg);
	}
}
