package com.iStudy.springboot.util;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

public class IpUtils {

	/**
	 * 获取客户端IP地址
	 * @param request
	 * @return
	 */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	             ip = request.getHeader("Proxy-Client-IP");
	        }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("WL-Proxy-Client-IP");
	         }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
	        }
        if (ip.equals("0:0:0:0:0:0:0:1")) {
            ip = "localhost";
        }
        return ip;
     }
    
    /**
     * 是否是Linux环境
     * @return
     */
    public static boolean isOSLinux() {
    	Properties prop = System.getProperties();
    	String os = prop.getProperty("os.name");
    	if (os != null && os.toLowerCase().indexOf("linux") > -1) {
    		 return true;
    	}else{
    		 return false;
    	}
     }
}
