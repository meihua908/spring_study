/**
 * 
 */
package com.iStudy.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iStudy.springboot.config.AsyncExecutorTask;

/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
    private AsyncExecutorTask task;

	@RequestMapping(value = "/hello",method=RequestMethod.POST)
	@ResponseBody
	public String hello(){
		return "hello!";
	}
		
	/**
	 * 线程池中异步执行
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/asyncExecutorTask")
	@ResponseBody
	public String TestAsyncExecutorTask() throws Exception{
		task.doTaskOne();
        task.doTaskTwo();
        task.doTaskThree();
		return "success";
	}
	
	
	/**
	 * 运行时异常
	 * @return
	 */
	@RequestMapping(value = "/exception1",method=RequestMethod.POST)
	@ResponseBody
	public String TestException1(){
		int  a = 1 / 0;
		return "success";
	}
	
	
	/**
	 * 空指针异常
	 * @return
	 */
	@RequestMapping(value = "/exception2",method=RequestMethod.POST)
	@ResponseBody
	public String TestException2(){
		String str = null;
		str.substring(0, 2);
		return "success";
	}
	
}
