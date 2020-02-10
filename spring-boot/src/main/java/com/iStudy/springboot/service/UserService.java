/**
 * 
 */
package com.iStudy.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iStudy.springboot.model.User;

/**
 * @author Administrator
 *
 */
@Service("userService")
public interface UserService  extends IService<User> {
	
	List<User> getAll();
	
	void asyncGetUser();
}
