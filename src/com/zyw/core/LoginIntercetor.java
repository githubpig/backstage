/**
 * tzdesk系统平台
 * tzupload
 * com.tz.core
 * LoginIntercetor.java
 * 创建人:xuchengfei 
 * 时间：2015年11月13日-下午9:51:18 
 * 2015潭州教育公司-版权所有
 */
package com.zyw.core;

import static com.zyw.util.TzConstant.SESSION_USER;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zyw.bean.AdminUser;
import com.zyw.util.PigStringUtils;

/**
 * 
 * LoginIntercetor
 * 创建人:xuchengfei 
 * 时间：2015年11月13日-下午9:51:18 
 * @version 1.0.0
 * 
 */
public class LoginIntercetor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("进来了吗..........");
		AdminUser adimUser =(AdminUser)request.getSession().getAttribute(SESSION_USER);
		if(adimUser!=null){
			return true;
		}else{
			String requestType = request.getHeader("X-Requested-With");
			if(PigStringUtils.isNotEmpty(requestType) && requestType.equalsIgnoreCase("XMLHttpRequest")){
				response.getWriter().print("logout");
			}else{
				response.sendRedirect(request.getContextPath()+"/login");
			}
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("请求结束执行的方法..........");
		
	}
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("响应已经被渲染成功后执行的方法..........");
		
	}

}
