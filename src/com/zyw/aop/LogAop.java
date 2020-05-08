/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.core
 * LogAop.java
 * 创建人:xuchengfei 
 * 时间：2015年12月4日-下午11:01:50 
 * 2015潭州教育公司-版权所有
 */
package com.zyw.aop;

import javax.servlet.ServletContext;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletContextAware;

import com.zyw.bean.AdminStat;
import com.zyw.bean.AdminUser;
import com.zyw.dao.adminstat.IAdminStatMapper;
/**
 * 
 * LogAop
 * 创建人:xuchengfei 
 * 时间：2015年12月4日-下午11:01:50 
 * @version 1.0.0
 * 
 */
//增强类
@Aspect
public class LogAop implements ServletContextAware {
	
	private ServletContext application;
	@Autowired
	private IAdminStatMapper mapper;
	
	@Override
	public void setServletContext(ServletContext application) {
		this.application = application;
	}
	@Around("execution(* com.zyw.service.*.*.*(..)) and not execution(* com.zyw.service.*.*.getLogin(..))")//环绕通知
	public Object doBasicProfiling(ProceedingJoinPoint point) throws Throwable {
		
		String methodName = point.getSignature().getName(); //方法名
		// 执行该方法  
		Object classObj = point.getTarget();			//拦截的类名
		long start = System.currentTimeMillis();
		Object object = point.proceed();
		long end = System.currentTimeMillis();
		long time = (end - start); 						//方法执行时间
		Object[] params = point.getArgs();
		StringBuilder builder = new StringBuilder("");
		if(params.length>0){
			for (int i = 0; i < params.length; i++) {
				builder.append(String.valueOf(params[i]));
				if(i<params.length-1){
					builder.append(",");
				}
			}
		}
		//拦截的的类的全类名
		String className = classObj.getClass().getName();
		//返回类型
		String returnType = null;
		if(object!=null){
			returnType = object.getClass().getName();
		}
		//保存日记到数据库
		saveLog(className,methodName,time);
		//System.out.println("【Tm】【Service AOP拦截】【Class："+className+"】【Method："+methodName+"】【ReturnType："+returnType+"】【Time："+time+"ms】");
		return object;
	}
	private void saveLog(String className, String methodName, long time) {
		String ip = (String) application.getAttribute("ip_log");
		String ipaddress = (String) application.getAttribute("ipAddress_log");
		AdminUser adminUser = (AdminUser) application.getAttribute("user_log");
		AdminStat adminStat = new AdminStat();
		adminStat.setClassname(className);
		adminStat.setUserId(adminUser.getId());
		adminStat.setUsername(adminUser.getUsername());
		adminStat.setMethod(methodName);
		adminStat.setRuntime(time);
		adminStat.setIpaddress(ipaddress);
		adminStat.setIp(ip);
		mapper.save(adminStat);
	}
}
