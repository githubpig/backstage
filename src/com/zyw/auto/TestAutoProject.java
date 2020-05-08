package com.zyw.auto;

import java.io.File;

public class TestAutoProject {
	
	public static String getRootPath(String path){
		return new File(System.getProperty("user.dir"),path).getAbsolutePath();
	}
	
	public static void main(String[] args) {
		//当前项目名：E:\Workspaces10\zyw_admin
		//System.out.println(System.getProperty("user.dir"));
		
		//E:\Workspaces10\zyw_admin\qqq
		//System.out.println(getRootPath("qqq"));
		
		//str: E:\Workspaces10\zyw_admin\qq
		//File str = new File("E://Workspaces10//zyw_admin//qq").getAbsoluteFile();
		//System.out.print(str);
		
//		Properties properties = System.getProperties();
//		Enumeration<Object> keys = properties.keys();
//		while(keys.hasMoreElements()){
//			Object object = keys.nextElement();
//			System.out.println("===="+properties.get(object));
//		}
	}
}
