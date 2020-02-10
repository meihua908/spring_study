/**
 * 
 */
package com.iStudy.springboot.config;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 *
 */
@Component
public class AsyncExecutorTask extends AbstractTask {

	/* (non-Javadoc)
	 * @see com.iStudy.springboot.config.AbstractTask#doTaskOne()
	 * 在taskExecutor中异步执行
	 */
	@Async("taskExecutor")
    public void doTaskOne() throws Exception {
        super.doTaskOne();
        System.out.println("任务一，当前线程：" + Thread.currentThread().getName());
    }
 
    @Async("taskExecutor")
    public void doTaskTwo() throws Exception {
        super.doTaskTwo();
        System.out.println("任务二，当前线程：" + Thread.currentThread().getName());
    }
 
    @Async("taskExecutor")
    public void doTaskThree() throws Exception {
        super.doTaskThree();
        System.out.println("任务三，当前线程：" + Thread.currentThread().getName());
    }

}
