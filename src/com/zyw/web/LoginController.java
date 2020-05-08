package com.zyw.web;

import static com.zyw.util.TzConstant.SESSION_USER;
import static com.zyw.util.TzConstant.SESSION_USER_ROLE;
import static com.zyw.util.TzConstant.SESSION_USER_USERNAME;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyw.bean.AdminUser;
import com.zyw.core.BaseController;
import com.zyw.service.adminuser.IAdimUserService;
import com.zyw.service.role.IRoleService;
import com.zyw.util.TmStringUtils;
import com.zyw.util.ip.TmIpUtil;

/**
 * 
 * 作用: 测试index页面
 * IndexController
 * 创建人:piggy
 * 时间:2017年5月6日-下午4:37:19
 */

@Controller
public class LoginController extends BaseController{
	
	@Autowired
	private IAdimUserService service;
	@Autowired
	private IRoleService  roleService;
	
	//测试登录页面
	@RequestMapping("login")
	public String index(){
		return "login";
	}
	
	@ResponseBody
	@RequestMapping(value="logined",method=RequestMethod.POST)
	public String logined(String account,String password){
		if(TmStringUtils.isNotEmpty(account) && TmStringUtils.isNotEmpty(password)){
			String md5Password = TmStringUtils.md5Base64(password);
			AdminUser adminUser = service.getLogin(account, md5Password);
			if(adminUser != null){
				if(adminUser.getForbiden() == 0){
					return "forbiden";
				}else{
					HashMap<String, Object> maps =  roleService.queryUserRole(adminUser.getId());
					session.setAttribute(SESSION_USER_ROLE,maps);
					session.setAttribute(SESSION_USER, adminUser);
					session.setAttribute(SESSION_USER_USERNAME, adminUser.getUsername());
					
					request.getServletContext().setAttribute("user_log", adminUser);
					request.getServletContext().setAttribute("ipAddress_log", TmIpUtil.ipLocation(request));
					request.getServletContext().setAttribute("ip_log", TmIpUtil.getIpAddress(request));
					return "success";
				}
			}else{
				return "error";
			}
		}else{
			return "null";
		}
	}
	@RequestMapping("/logout")
	public String logout(){
		session.invalidate();
		return "redirect:login";
	}
}
