/**
 * 
 */
package com.iStudy.springboot.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iStudy.springboot.model.User;
import com.iStudy.springboot.service.UserService;
import com.iStudy.springboot.util.RedisUtil;
import com.iStudy.springboot.util.ResultUtil;

/**
 * @author Administrator
 * 
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
    private RedisUtil redisUtil;
	
	/**
	 * 从redis中获取数据
	 * @return
	 */
	@RequestMapping(value = "/getUserById",method=RequestMethod.POST)
	public Map<String,Object> getUserById(@RequestParam(name ="id") String id){
		User user = null;
		User userObj = (User)redisUtil.get(id);
		if(userObj != null){
			user = userObj;
		}else{
			user = userService.selectByKey(id);
			redisUtil.set(id, user);
		}
		return ResultUtil.getMessageAndData(true, "操作成功", user);
	}
	
	
	/**
	 * 从ehcache中获取数据
	 * @return
	 */
	@RequestMapping(value = "/getAllUser")
	public Map<String,Object> getAllUser(){
		List<User> userList = userService.getAll();
		return ResultUtil.getMessageAndData(true, "操作成功", userList);
	}
	
	
	/**
	 * 新增user
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/saveNewUser")
	public Map<String,Object> saveNewUser(@RequestBody User user){
		userService.save(user);
		return ResultUtil.getMessageAndData(true, "操作成功", "");
	}
	
	
	/**
	 * 异步获取数据
	 * @return
	 */
	@RequestMapping(value = "/asyncGetUser")
	public Map<String,Object> asyncGetUser(){
		userService.asyncGetUser();
		return ResultUtil.getMessageAndData(true, "操作成功", "");
	}
	
}
