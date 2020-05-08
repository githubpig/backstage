package com.zyw.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zyw.bean.Content;
import com.zyw.bean.ZywParams;
import com.zyw.service.content.IContentService;

/**
 * 
 * 作用:内容控制层
 * 类名：ContentController
 * 创建人:pig
 * 时间:2017年5月7日-下午5:13:21
 * 手机号 : 15237360630
 * 2017年pig公司-版权所有
 */
@Controller
@RequestMapping("admin/content")
public class ContentController {
	
	@Autowired
	private IContentService contentService;
	
	@RequestMapping("/list")
	public ModelAndView list(ZywParams params){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/content/list");
		return modelAndView;
	}
	//url请求参数 要与 ZywParams 的属性名 相同
	@RequestMapping("/template")
	public ModelAndView template(ZywParams params){
		System.out.println(params.getPageNo() +"====="+ params.getPageSize());
		ModelAndView modelAndView = new ModelAndView();
		params.setIsDelete(0);
		List<Content> contents = contentService.queryContents(params);
		int count = contentService.countContent(params);
		modelAndView.setViewName("/content/template");
		modelAndView.addObject("contents",contents);
		modelAndView.addObject("count",count);
		return modelAndView;
	}
	@ResponseBody
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String update(Content content){
		contentService.update(content);
		return "success";
	}
	@ResponseBody
	@RequestMapping(value="/delete",method = RequestMethod.POST)
	public String delete(ZywParams params){
		contentService.delete(params);
		return "success";
	}
}
