package com.zyw.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 作用: 测试index页面
 * IndexController
 * 创建人:piggy
 * 时间:2017年5月6日-下午4:37:19
 */

@Controller
@RequestMapping("/admin")
public class IndexController {
	
	@RequestMapping("index")
	public String index(){
		return "index";
	}
	
}
