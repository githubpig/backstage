package com.zyw.web;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zyw.bean.ZywParams;
import com.zyw.service.adminstat.IContentStatService;

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
@RequestMapping("admin/stat")
public class StatController {
	
	@Autowired
	private IContentStatService contentStatService;
	
	@RequestMapping("/list")
	public ModelAndView list(ZywParams params){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/adminstat/list");
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("/listData")
	public List<HashMap<String, Object>> data(ZywParams params){
		List<HashMap<String, Object>> maps = contentStatService.contentStat(params);
		return maps;
	}
}
