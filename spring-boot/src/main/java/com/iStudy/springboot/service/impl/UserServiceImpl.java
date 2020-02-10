/**
 * 
 */
package com.iStudy.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.iStudy.springboot.mapper.UserMapper;
import com.iStudy.springboot.model.User;
import com.iStudy.springboot.service.UserService;

/**
 * @author Administrator
 *
 */
@Service("userService")
public class UserServiceImpl extends BaseService<User> implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Cacheable(value = "userCache")
	@Override
	public List<User> getAll() {
		return userMapper.getAll();
	}

	@Async
	@Override
	public void asyncGetUser() {
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(2000);
				System.out.println("the user is :" + (i+1));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
