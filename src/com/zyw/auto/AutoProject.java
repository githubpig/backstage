package com.zyw.auto;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

import com.zyw.util.TmFileUtil;
import com.zyw.util.TmStringUtils;
/**
 * 
 * 作用: 
 * 		 替换属性内容 ：第一级别： 模板
 * 					二 ：包名， 类名 
 * 					三 ： 创建人 ,手机号,时间
 * 类名：AutoProject
 * 创建人:pig
 * 时间:2017年5月8日-下午12:40:02
 * 手机号 : 15237360630
 * 2017年pig公司-版权所有
 */
public class AutoProject {
	
	//模板
	private static String beanTemplate = "template/bean.txt"; //Bean 模板
	private static String mapperTemplate = "template/mapper.txt"; //BeanMapper 模板
	private static String sqlxmlTemplate = "template/sqlxml.txt";
	private static String serviceTemplate = "template/service.txt";
	private static String serviceImplTemplate = "template/serviceImpl.txt";
	private static String listjspTemplate = "template/list.txt";
	private static String templateTemplate = "template/template.txt";
	
	private static String webTemplate = "template/web.txt";
	
	//类
	private static String paramsName = "ZywParams";
	private static String beanName = "Gather";//类名
	private static String beanNameLower = beanName.toLowerCase();//类名首字母小写
	
	//文件路径
	private static String srcDir = "src/";
	private static String beanDir = "com/zyw/bean";
	private static String daoDir = "com/zyw/dao";
	private static String serviceDir = "com/zyw/service";
	private static String serviceImplDir = "com/zyw/service/"+beanNameLower+"/impl";
	private static String webDir = "com/zyw/web";
	private static String pageDirs = "/WebRoot/WEB-INF/pages/"+beanNameLower+"/";
	//包名
	private static String beanPackage = getPackage(beanDir);
	private static String daoPackage = getPackage(daoDir);
	private static String servicePackage = getPackage(serviceDir);
	private static String serviceImplPackage = getPackage(serviceImplDir);
	private static String webPackage = getPackage(webDir);
	//注释
	private static String author = "pig";
	private static String date = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss").format(new Date());
	private static String phone = "15237360630";
	
	
	//page想面的 list.jsp 页面
	public static void createTemplate(){
		//创建 java 文件
		Boolean flag = false;
		String rootPath = getRootPath(pageDirs);
		File beanFile = new File(rootPath);
     	if(!beanFile.exists())beanFile.mkdirs();
		File entityFile = new File(rootPath, "template.jsp");//创建java文件 
		if(!entityFile.exists()){
			flag = true;
		}else{
			Scanner sc = new Scanner(System.in);//entityFile.getAbsolutePath()
			System.out.println(entityFile.getAbsolutePath()+"文件已经存在,您是否要覆盖文件(y/n)?");
			String mark = sc.nextLine();
			if(mark.equalsIgnoreCase("y")){
				flag = true;
			}else if(mark.equalsIgnoreCase("n")){
				flag = false;
			}
		}
		if(flag){
			String templatePath = getRootPath(templateTemplate);//拿到模板路径
			String content = TmFileUtil.readFileByLines(templatePath);//内容
			content = replaceTemplate(content);
			try {
				FileUtils.writeStringToFile(entityFile.getAbsoluteFile(), content, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	//page想面的 list.jsp 页面
	public static void createPage(){
		//创建 java 文件
		Boolean flag = false;
		String rootPath = getRootPath(pageDirs);
		File beanFile = new File(rootPath);
     	if(!beanFile.exists())beanFile.mkdirs();
		File entityFile = new File(rootPath, "list.jsp");//创建java文件 
		if(!entityFile.exists()){
			flag = true;
		}else{
			Scanner sc = new Scanner(System.in);//entityFile.getAbsolutePath()
			System.out.println(entityFile.getAbsolutePath()+"文件已经存在,您是否要覆盖文件(y/n)?");
			String mark = sc.nextLine();
			if(mark.equalsIgnoreCase("y")){
				flag = true;
			}else if(mark.equalsIgnoreCase("n")){
				flag = false;
			}
		}
		if(flag){
			String templatePath = getRootPath(listjspTemplate);//拿到模板路径
			String content = TmFileUtil.readFileByLines(templatePath);//内容
			content = replaceTemplate(content);
			try {
				FileUtils.writeStringToFile(entityFile.getAbsoluteFile(), content, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	//Web层:控制层
	public static void createWeb(){
		//创建 java 文件
		Boolean flag = false;
		String rootPath = getRootPath(srcDir + webDir);
		File beanFile = new File(rootPath);
     	if(!beanFile.exists())beanFile.mkdirs();
		File entityFile = new File(rootPath, beanName+"Controller"+".java");//创建java文件 
		if(!entityFile.exists()){
			flag = true;
		}else{
			Scanner sc = new Scanner(System.in);//entityFile.getAbsolutePath()
			System.out.println(entityFile.getAbsolutePath()+"文件已经存在,您是否要覆盖文件(y/n)?");
			String mark = sc.nextLine();
			if(mark.equalsIgnoreCase("y")){
				flag = true;
			}else if(mark.equalsIgnoreCase("n")){
				flag = false;
			}
		}
		if(flag){
			String templatePath = getRootPath(webTemplate);//拿到模板路径
			String content = TmFileUtil.readFileByLines(templatePath);//内容
			content = replaceTemplate(content);
			try {
				FileUtils.writeStringToFile(entityFile.getAbsoluteFile(), content, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	//ServiceImpl：service实现层
	public static void createServiceImpl(){
		//创建 java 文件
		Boolean flag = false;
		String rootPath = getRootPath(srcDir + serviceImplDir);
		File beanFile = new File(rootPath);
     	if(!beanFile.exists())beanFile.mkdirs();
		File entityFile = new File(rootPath, beanName+"ServiceImpl"+".java");//创建java文件 
		if(!entityFile.exists()){
			flag = true;
		}else{
			Scanner sc = new Scanner(System.in);
			System.out.println(entityFile.getAbsolutePath()+"文件已经存在,您是否要覆盖文件(y/n)?");
			String mark = sc.nextLine();
			if(mark.equalsIgnoreCase("y")){
				flag = true;
			}else if(mark.equalsIgnoreCase("n")){
				flag = false;
			}
		}
		if(flag){
			String templatePath = getRootPath(serviceImplTemplate);//拿到模板路径
			String content = TmFileUtil.readFileByLines(templatePath);//内容
			content = replaceTemplate(content);
			try {
				FileUtils.writeStringToFile(entityFile.getAbsoluteFile(), content, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	//service层的接口
	public static void createService(){
		//创建 java 文件
		Boolean flag = false;
		String rootPath = getRootPath(srcDir + serviceDir +"/"+beanNameLower);
		File beanFile = new File(rootPath);
     	if(!beanFile.exists())beanFile.mkdirs();
		File entityFile = new File(rootPath,"I"+beanName+"Service"+".java");//创建java文件 
		if(!entityFile.exists()){
			flag = true;
		}else{
			Scanner sc = new Scanner(System.in);
			System.out.println(entityFile.getAbsolutePath()+"文件已经存在,您是否要覆盖文件(y/n)?");
			String mark = sc.nextLine();
			if(mark.equalsIgnoreCase("y")){
				flag = true;
			}else if(mark.equalsIgnoreCase("n")){
				flag = false;
			}
		}
		if(flag){
			String templatePath = getRootPath(serviceTemplate);//拿到模板路径
			String content = TmFileUtil.readFileByLines(templatePath);//内容
			content = replaceTemplate(content);
			try {
				FileUtils.writeStringToFile(entityFile.getAbsoluteFile(), content, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	//sqlXml
	public static void createSQLXML(){
		//创建 java 文件
		Boolean flag = false;
		String rootPath = getRootPath(srcDir + daoDir +"/"+beanNameLower);
		File beanFile = new File(rootPath);
     	if(!beanFile.exists())beanFile.mkdirs();
		File entityFile = new File(rootPath,beanName+".xml");//创建java文件 
		if(!entityFile.exists()){
			flag = true;
		}else{
			Scanner sc = new Scanner(System.in);
			System.out.println(entityFile.getAbsolutePath()+"文件已经存在,您是否要覆盖文件(y/n)?");
			String mark = sc.nextLine();
			if(mark.equalsIgnoreCase("y")){
				flag = true;
			}else if(mark.equalsIgnoreCase("n")){
				flag = false;
			}
		}
		if(flag){
			String templatePath = getRootPath(sqlxmlTemplate);//拿到模板路径
			String content = TmFileUtil.readFileByLines(templatePath);//内容
			content = replaceTemplate(content);
			try {
				FileUtils.writeStringToFile(entityFile.getAbsoluteFile(), content, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	//dao(mapper接口)
	public static void createDao(){
		//创建 java 文件
		Boolean flag = false;
		String rootPath = getRootPath(srcDir + daoDir +"/"+beanNameLower);
		File beanFile = new File(rootPath);
     	if(!beanFile.exists())beanFile.mkdirs();
		File entityFile = new File(rootPath,"I"+beanName+"Mapper"+".java");//创建java文件 
		if(!entityFile.exists()){
			flag = true;
		}else{
			Scanner sc = new Scanner(System.in);
			System.out.println(entityFile.getAbsolutePath()+"文件已经存在,您是否要覆盖文件(y/n)?");
			String mark = sc.nextLine();
			if(mark.equalsIgnoreCase("y")){
				flag = true;
			}else if(mark.equalsIgnoreCase("n")){
				flag = false;
			}
		}
		if(flag){
			String templatePath = getRootPath(mapperTemplate);//拿到模板路径
			String content = TmFileUtil.readFileByLines(templatePath);//内容
			content = replaceTemplate(content);
			try {
				FileUtils.writeStringToFile(entityFile.getAbsoluteFile(), content, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//修改列表 ：模板： beanTemplate，类名：beanName， 目录：beanDir，
	//创建的是src 下的目录，创建其他目录，去掉 : srcDir
	public static void createBean(){
		//创建 java 文件
		Boolean flag = false;
		String rootPath = getRootPath(srcDir + beanDir);
		File beanFile = new File(rootPath);
		if(!beanFile.exists())beanFile.mkdirs();
		File entityFile = new File(rootPath,beanName+".java");//创建java文件 
		
		if(!entityFile.exists()){
			flag = true;
		}else{
			Scanner sc = new Scanner(System.in);
			System.out.println(entityFile.getAbsolutePath()+"文件已经存在,您是否要覆盖文件(y/n)?");
			String mark = sc.nextLine();
			if(mark.equalsIgnoreCase("y")){
				flag = true;
			}else if(mark.equalsIgnoreCase("n")){
				flag = false;
			}
		}
		if(flag){
			String templatePath = getRootPath(beanTemplate);//拿到模板路径
			String content = TmFileUtil.readFileByLines(templatePath);//内容
			content = replaceTemplate(content);
			try {
				FileUtils.writeStringToFile(entityFile.getAbsoluteFile(), content, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	//替换 
	public static String replaceTemplate(String content){
		if(TmStringUtils.isNotEmpty(content)){
			content = content.replaceAll("\\[beanPackage\\]", beanPackage)
							 .replaceAll("\\[daoPackage\\]", daoPackage)
							 .replaceAll("\\[webPackage\\]", webPackage)
							 .replaceAll("\\[servicePackage\\]", servicePackage)
							 .replaceAll("\\[serviceImplPackage\\]", serviceImplPackage)
							 .replaceAll("\\[beanName\\]", beanName)
							 .replaceAll("\\[beanNameLower\\]", beanNameLower)
							 .replaceAll("\\[author\\]", author)
							 .replaceAll("\\[date\\]", date)
							 .replaceAll("\\[phone\\]", phone)
							 .replaceAll("\\[paramsName\\]", paramsName);
			return content;
		}else{
			return "error";
		}
	}
	//包名称
	public static String getPackage(String dirPath){
		
		return  dirPath.replaceAll("/", ".");
	}
	
	//获取路径
	public static String getRootPath(String path){
		return new File(System.getProperty("user.dir"),path).getAbsolutePath();
	}
	
	public static void main(String[] args) {
		createBean();
		createDao();
		createSQLXML();
		createService();
		createServiceImpl();
		createWeb();
		createPage();
		createTemplate();
		System.out.println("程序结束！！！");
	}
}
