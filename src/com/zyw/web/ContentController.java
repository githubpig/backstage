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
 * ����:���ݿ��Ʋ�
 * ������ContentController
 * ������:pig
 * ʱ��:2017��5��7��-����5:13:21
 * �ֻ��� : 15237360630
 * 2017��pig��˾-��Ȩ����
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
	//url������� Ҫ�� ZywParams �������� ��ͬ
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
