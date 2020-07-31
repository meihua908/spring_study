package com.iStudy.springboot.util;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.config.Task;



public class ThreadUtil {

	public static void main(String[] args) {
		
		/*
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				
			}
		});
		t.start();*/
		
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 100, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		
	
		pool.shutdown();
	}

}
