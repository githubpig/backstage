package com.zyw.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zyw.bean.Message;
import com.zyw.bean.ZywParams;
import com.zyw.service.message.IMessageService;

/**
 * 
 * 作用:内容控制层
 * 类名：MessageController
 * 创建人:pig
 * 时间:2017年05月13日 06:08:59
 * 手机号 : 15237360630
 * pig公司-版权所有
 */
@Controller
@RequestMapping("admin/message")
public class MessageController {
	
	@Autowired
	private IMessageService messageService;
	
	@RequestMapping("/list")
	public ModelAndView list(ZywParams params){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/message/list");
		return modelAndView;
	}
	//url请求参数 要与 ZywParams 的属性名 相同
	@RequestMapping("/template")
	public ModelAndView template(ZywParams params){
		System.out.println(params.getPageNo() +"====="+ params.getPageSize());
		ModelAndView modelAndView = new ModelAndView();
		List<Message> messages = messageService.queryMessages(params);
		int count = messageService.countMessage(params);
		modelAndView.setViewName("/message/template");
		modelAndView.addObject("messages",messages);
		modelAndView.addObject("count",count);
		return modelAndView;
	}
}
