/**
 * 
 */
package com.iStudy.springboot.web;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iStudy.springboot.model.User;
import com.iStudy.springboot.service.LoginService;
import com.iStudy.springboot.util.ResultUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;


	@ApiOperation(value="用户登录", notes="根据用户名，密码来做shiro权限认证")
	/*@ApiImplicitParams({
		@ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String", paramType = "path"),
		@ApiImplicitParam(name = "pwd", value = "密码", required = true, dataType = "String", paramType = "path")
	})*/
	@RequestMapping("/login")
    public Map<String, Object> login(User user) {
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getName(),user.getPwd());
      //进行验证，这里可以捕获异常，然后返回对应信息
        subject.login(usernamePasswordToken);
        String name = usernamePasswordToken.getUsername();
        user = loginService.getUserByName(name);
		// subject.checkRole("admin");
		// subject.checkPermissions("query", "add");
        return ResultUtil.getMessageAndData(true, "操作成功", user);
    }
	
	
     //注解验角色和权限
    @RequiresRoles("admin")
    @RequiresPermissions("add")
    @RequestMapping("/index")
    public String index() {
        return "index!";
    }
}
