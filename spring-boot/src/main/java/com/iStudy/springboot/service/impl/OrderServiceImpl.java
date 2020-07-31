/**
 * 
 */
package com.iStudy.springboot.service.impl;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iStudy.springboot.mapper.OrderMapper;
import com.iStudy.springboot.model.Order;
import com.iStudy.springboot.service.OrderService;

/**
 * @author ftchen
 *
 */
@Service
public class OrderServiceImpl  extends BaseService<Order> implements OrderService {
	
	@Autowired
	private OrderMapper orderMapper;
	
	private ReentrantLock lock = new ReentrantLock();

	@Override
	public String getOrderList() {
		Integer stock;
		try{
			lock.lock();  //枷锁
			Order order = orderMapper.selectByPrimaryKey(1);
			stock = order.getStock();
			if(order == null || stock <= 0){
				System.out.println("下单失败，没有库存了");
				return "下单失败，没有库存了";
			}
			stock --;
			Order paramOrder = new Order();
			paramOrder.setId(1);
			paramOrder.setStock(stock);
			orderMapper.updateByPrimaryKey(paramOrder);
			System.out.println("下单成功，当前剩余产品个数："+stock);
		}finally{
			lock.unlock();  //释放锁
		}
		return "下单成功，当前剩余产品个数："+stock;
	}
}
