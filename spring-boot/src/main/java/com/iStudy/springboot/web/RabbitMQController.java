/**
 * 
 */
package com.iStudy.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iStudy.springboot.service.impl.RabbitMQProducer;

/**
 * @author ftchen
 *
 */
@RestController
@RequestMapping("/rabbitmq")
public class RabbitMQController {

	@Autowired
	RabbitMQProducer rabbitMQProducer;
	
	@RequestMapping("/sendMsg")
	public String sendFanout() {
		rabbitMQProducer.send("test_queue");
		return "success";
	}
}
