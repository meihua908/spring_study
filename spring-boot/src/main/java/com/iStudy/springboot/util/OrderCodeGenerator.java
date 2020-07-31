/**
 * 
 */
package com.iStudy.springboot.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ftchen
 *	订单号生成
 */
public class OrderCodeGenerator {
	
	private static  int count = 0;

	public static String getOrderCode(){
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
		
		String orderCode = format.format(new Date()) + "-" + ++count;
		
		return orderCode;
	}
}
