package com.zyw.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zyw.bean.AdminUser;
import com.zyw.bean.ZywParams;
import com.zyw.service.adminuser.IAdimUserService;


/**
 * 
 * 作用:内容控制层
 * 类名：AdminUserController
 * 创建人:pig
 * 时间:2017年05月14日 09:24:55
 * 手机号 : 15237360630
 * pig公司-版权所有
 */
@Controller
@RequestMapping("admin/adminuser")
public class AdminUserController {
	
	@Autowired
	private IAdimUserService adminuserService;
	
	@RequestMapping("/list")
	public ModelAndView list(ZywParams params){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/adminuser/list");
		return modelAndView;
	}
	//url请求参数 要与 ZywParams 的属性名 相同
	@RequestMapping("/template")
	public ModelAndView template(ZywParams params){
		System.out.println(params.getPageNo() +"====="+ params.getPageSize());
		ModelAndView modelAndView = new ModelAndView();
		List<AdminUser> adminusers = adminuserService.query();
		int count = adminuserService.count(params);
		modelAndView.setViewName("/adminuser/template");
		modelAndView.addObject("adminusers",adminusers);
		modelAndView.addObject("count",count);
		return modelAndView;
	}
}
