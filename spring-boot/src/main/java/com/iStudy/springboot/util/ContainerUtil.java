package com.iStudy.springboot.util;

import java.util.ArrayList;
import java.util.List;

public class ContainerUtil {
	
	volatile List<Object> list = new ArrayList<Object>();
	
	public void add(Object obj){
		list.add(obj);
	}
	
	public int size(){
		return list.size();
	}

	public static void main(String[] args) {
		ContainerUtil c = new ContainerUtil();
		new Thread(()->{
			for(int i=0;i<10;i++){
				c.add(new Object());
				System.out.println("---add---"+i);
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		new Thread(()->{
			while(true){
				if(c.size() == 5){
					System.out.println("t2线程结束");
					break;
				}
			}
		}).start();
	}

}
