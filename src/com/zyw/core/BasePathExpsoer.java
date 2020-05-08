
package com.zyw.core;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ServletContextAware;

import com.zyw.util.TmStringUtils;

/**
 * 
 * BasePathExpsoer
 * 锟斤拷锟斤拷锟斤拷:xuchengfei 
 * 时锟戒：2015锟斤拷11锟斤拷13锟斤拷-锟斤拷锟斤拷10:27:57 
 * @version 1.0.0
 * 
 */
public class BasePathExpsoer  implements ServletContextAware{

	private ServletContext application;
	private ApplicationContext context;

	private String rootPath;
	public void init(){
		if(TmStringUtils.isEmpty(rootPath)){
			rootPath = application.getContextPath();
		}
		application.setAttribute("rootPath", rootPath);
		application.setAttribute("resPath", rootPath+"/resources");
	}
	
	@Override
	public void setServletContext(ServletContext application) {
		this.application = application;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}
	
}
