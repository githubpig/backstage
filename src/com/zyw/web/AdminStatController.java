package com.zyw.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zyw.bean.AdminStat;
import com.zyw.bean.ZywParams;
import com.zyw.service.adminstat.IAdminStatService;

/**
 * 
 * 作用:内容控制层
 * 类名：AdminStatController
 * 创建人:pig
 * 时间:2017年05月14日 06:10:31
 * 手机号 : 15237360630
 * pig公司-版权所有
 */
@Controller
@RequestMapping("admin/adminstat")
public class AdminStatController {
	
	@Autowired
	private IAdminStatService adminstatService;
	
	@RequestMapping("/fun")
	public ModelAndView fun(ZywParams params){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/adminstat/fun");
		return modelAndView;
	}
	//url请求参数 要与 ZywParams 的属性名 相同
	@RequestMapping("/template")
	public ModelAndView template(ZywParams params){
		System.out.println(params.getPageNo() +"====="+ params.getPageSize());
		ModelAndView modelAndView = new ModelAndView();
		List<AdminStat> adminstats = adminstatService.queryAdminStats(params);
		int count = adminstatService.countAdminStat(params);
		modelAndView.setViewName("/adminstat/template");
		modelAndView.addObject("adminstats",adminstats);
		modelAndView.addObject("count",count);
		return modelAndView;
	}
}
