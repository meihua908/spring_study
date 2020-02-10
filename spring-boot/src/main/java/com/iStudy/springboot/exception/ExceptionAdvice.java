package com.iStudy.springboot.exception;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.xml.ws.WebServiceException;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iStudy.springboot.model.Log;
import com.iStudy.springboot.util.IpUtils;
import com.iStudy.springboot.util.ResultUtil;

import org.springframework.web.bind.MethodArgumentNotValidException;

@ControllerAdvice
public class ExceptionAdvice {
	
	/*@Autowired
	private LogService logService;*/
	
	
    @ResponseBody
    @ExceptionHandler
    public Map<String, Object> ErrorHandler(AuthorizationException e) {
		e.printStackTrace();
        return ResultUtil.getMessageAndData(false, "权限不足", e.toString());
    }
    
    @ResponseBody
    @ExceptionHandler(value = IncorrectCredentialsException.class)
    public Map<String, Object> IncorrectCredentialsException(IncorrectCredentialsException exception){
    	exception.printStackTrace();
    	return   ResultUtil.getMessageAndData(false, "用户名或者密码错误", exception.toString());
    }
    
    @ResponseBody
    @ExceptionHandler(value = UnknownAccountException.class)
    public Map<String, Object> UnknownAccountException(UnknownAccountException exception){
    	exception.printStackTrace();
    	return   ResultUtil.getMessageAndData(false, "没有登录", exception.toString());
    }
    
	/**
	 * 空指针异常
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(value = NullPointerException.class)
	public Map<String, Object> NullPointExceptionHandler(NullPointerException e){
		e.printStackTrace();
		return  ResultUtil.getMessageAndData(false, "空指针异常", e.toString());
	}
	
   /**
    * 拦截捕捉自定义异常 ConstraintViolationException.class
    * @param
    * @return
    */
   @ResponseBody
   @ExceptionHandler(value = ConstraintViolationException.class)
   public Map<String, Object> ConstraintViolationExceptionHandler(ConstraintViolationException exception) {
      return   ResultUtil.getMessageAndData(false, "传参异常", exception.toString());
   }
   
   /**
    * 传参异常
	 * @param exception
	 * @return
	 */
   @ResponseBody
   @ExceptionHandler(value = BindException.class)
   public Map<String, Object> BindException(BindException exception){
	   
   	return   ResultUtil.getMessageAndData(false, "传参异常", exception.toString());
   }
   
   
   /**
    * 传参异常
	 * @param exception
	 * @return
	 */
   @ResponseBody
   @ExceptionHandler(value = MethodArgumentNotValidException.class)
   public Map<String, Object> MethodArgumentNotValidException(MethodArgumentNotValidException exception){
	   
	   return   ResultUtil.getMessageAndData(false, "传参异常", exception.toString());
   }

   /**
    * 运行时异常
	 * @param exception
	 * @return
	 */
    @ResponseBody
    @ExceptionHandler(value = RuntimeException.class)
    public Map<String, Object> RuntimeException(RuntimeException exception){
    	exception.printStackTrace();
        return   ResultUtil.getMessageAndData(false, "运行时异常", exception.toString());
    }
   
   /**
    * 数组下标越界
	 * @param exception
	 * @return
	 */
    @ResponseBody
    @ExceptionHandler(value = IndexOutOfBoundsException.class)
    public Map<String, Object> IndexOutOfBoundsException(IndexOutOfBoundsException exception){
    	
        return   ResultUtil.getMessageAndData(false, "数组下标越界", exception.toString());
    }

    @ExceptionHandler(value = WebServiceException.class)
    public WebServiceException WebServiceException(WebServiceException exception){
        return  exception;
    }

   @ResponseBody
   @ExceptionHandler(value=Exception.class)
   public Map<String, Object> defaultErrorHandler(Exception exception,HttpServletRequest request){
		// 插入异常日志到数据库
	   	//User loginUser = UserUtil.getUser();
	   	String ip = IpUtils.getIpAddr(request);
	   	
		Log log = new Log();
		//log.setCreateBy(loginUser.getLoginCode());
		//log.setCreateByName(loginUser.getUserName());
		log.setCreateDate(new Date());
		log.setRemoteAddr(ip);
		log.setRequestUri(request.getRequestURI());
		log.setRequestMethod(request.getMethod());
		log.setRequestParams(request.getParameterMap());
		log.setExceptionInfo(exception.toString());
		//log.setCorpCode(loginUser.getCorpCode());
		//this.logService.saveNotNull(log);
	   return   ResultUtil.getMessageAndData(false, "发生异常", exception.toString());
   }
}