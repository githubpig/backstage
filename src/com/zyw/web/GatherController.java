package com.zyw.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zyw.bean.ZywParams;


/**
 * 
 * 作用:内容控制层
 * 类名：GatherController
 * 创建人:pig
 * 时间:2017年05月24日 05:58:01
 * 手机号 : 15237360630
 * pig公司-版权所有
 */
@Controller
@RequestMapping("admin/gather")
public class GatherController {
	
	@RequestMapping("/list")
	public ModelAndView list(ZywParams params){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/gather/list");
		return modelAndView;
	}

}
