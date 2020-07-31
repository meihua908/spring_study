/**
 * 
 */
package com.iStudy.springboot.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iStudy.springboot.service.OrderService;
import com.iStudy.springboot.util.ResultUtil;

/**
 * @author ftchen
 * 订单
 */
@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("updateOrder")
	public Map<String, Object> updateOrder(){
		String result = orderService.getOrderList();
		return ResultUtil.getMessageAndData(true, "操作成功", result);
	}
	
	
}
