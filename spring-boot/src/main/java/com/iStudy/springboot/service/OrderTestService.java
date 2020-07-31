/**
 * 
 */
package com.iStudy.springboot.service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.iStudy.springboot.util.OrderCodeGenerator;

/**
 * @author ftchen
 *
 */
public class OrderTestService implements Runnable{
	
	private static OrderCodeGenerator orderCodeGenerator = new OrderCodeGenerator();
	//模拟30个并发
	private static CountDownLatch countDownLatch = new CountDownLatch(30);
	
	private static Lock lock = new ReentrantLock();

	@Override
	public void run() {
		//方法1
		/*synchronized (countDownLatch) {
			System.out.println("生成订单号code:"+orderCodeGenerator.getOrderCode());
			 countDownLatch.countDown(); //减一
		}*/
		//方法2
		try {
			lock.lock();
			System.out.println("生成订单号code:"+orderCodeGenerator.getOrderCode());
			countDownLatch.countDown(); //减一
		}finally{
			lock.unlock();  //防止发生死锁问题
		}
	}
	
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		for(int i=0;i<30;i++){
			new Thread(new OrderTestService()).start();
		}
		countDownLatch.await(); //阻塞
		
		Thread.currentThread().join();
	}

}
