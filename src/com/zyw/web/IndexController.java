package com.zyw.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * ����: ����indexҳ��
 * IndexController
 * ������:piggy
 * ʱ��:2017��5��6��-����4:37:19
 */

@Controller
@RequestMapping("/admin")
public class IndexController {
	
	@RequestMapping("index")
	public String index(){
		return "index";
	}
	
}
