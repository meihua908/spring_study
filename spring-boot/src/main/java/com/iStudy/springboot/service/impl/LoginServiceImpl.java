package com.iStudy.springboot.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.iStudy.springboot.model.Permissions;
import com.iStudy.springboot.model.Role;
import com.iStudy.springboot.model.User;
import com.iStudy.springboot.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Override
	public User getUserByName(String userName) {
		//共添加两个用户，两个用户都是admin一个角色，
        //wsl有query和add权限，zhangsan只有一个query权限
        Permissions permissions1 = new Permissions("1","query");
        Permissions permissions2 = new Permissions("2","add");
        Set<Permissions> permissionsSet = new HashSet<>();
        permissionsSet.add(permissions1);
        permissionsSet.add(permissions2);
        
        Role role = new Role("1","admin",permissionsSet);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        User user = new User();
        user.setId(1);
        user.setName("wsl");
        user.setPwd("123456");
        user.setRoles(roleSet);
        Map<String ,User> map = new HashMap<>();
        map.put(user.getName(), user);

        Permissions permissions3 = new Permissions("3","query");
        Set<Permissions> permissionsSet1 = new HashSet<>();
        permissionsSet1.add(permissions3);
        Role role1 = new Role("2","user",permissionsSet1);
        Set<Role> roleSet1 = new HashSet<>();
        roleSet1.add(role1);
        User user1 = new User();
        user1.setId(2);
        user1.setName("zhangsan");
        user1.setPwd("123456");
        user1.setRoles(roleSet1);
        map.put(user1.getName(), user1);
        
        return map.get(userName);
	}

}
