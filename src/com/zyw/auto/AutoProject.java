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
 * ����: 
 * 		 �滻�������� ����һ���� ģ��
 * 					�� �������� ���� 
 * 					�� �� ������ ,�ֻ���,ʱ��
 * ������AutoProject
 * ������:pig
 * ʱ��:2017��5��8��-����12:40:02
 * �ֻ��� : 15237360630
 * 2017��pig��˾-��Ȩ����
 */
public class AutoProject {
	
	//ģ��
	private static String beanTemplate = "template/bean.txt"; //Bean ģ��
	private static String mapperTemplate = "template/mapper.txt"; //BeanMapper ģ��
	private static String sqlxmlTemplate = "template/sqlxml.txt";
	private static String serviceTemplate = "template/service.txt";
	private static String serviceImplTemplate = "template/serviceImpl.txt";
	private static String listjspTemplate = "template/list.txt";
	private static String templateTemplate = "template/template.txt";
	
	private static String webTemplate = "template/web.txt";
	
	//��
	private static String paramsName = "ZywParams";
	private static String beanName = "Gather";//����
	private static String beanNameLower = beanName.toLowerCase();//��������ĸСд
	
	//�ļ�·��
	private static String srcDir = "src/";
	private static String beanDir = "com/zyw/bean";
	private static String daoDir = "com/zyw/dao";
	private static String serviceDir = "com/zyw/service";
	private static String serviceImplDir = "com/zyw/service/"+beanNameLower+"/impl";
	private static String webDir = "com/zyw/web";
	private static String pageDirs = "/WebRoot/WEB-INF/pages/"+beanNameLower+"/";
	//����
	private static String beanPackage = getPackage(beanDir);
	private static String daoPackage = getPackage(daoDir);
	private static String servicePackage = getPackage(serviceDir);
	private static String serviceImplPackage = getPackage(serviceImplDir);
	private static String webPackage = getPackage(webDir);
	//ע��
	private static String author = "pig";
	private static String date = new SimpleDateFormat("yyyy��MM��dd�� hh:mm:ss").format(new Date());
	private static String phone = "15237360630";
	
	
	//page����� list.jsp ҳ��
	public static void createTemplate(){
		//���� java �ļ�
		Boolean flag = false;
		String rootPath = getRootPath(pageDirs);
		File beanFile = new File(rootPath);
     	if(!beanFile.exists())beanFile.mkdirs();
		File entityFile = new File(rootPath, "template.jsp");//����java�ļ� 
		if(!entityFile.exists()){
			flag = true;
		}else{
			Scanner sc = new Scanner(System.in);//entityFile.getAbsolutePath()
			System.out.println(entityFile.getAbsolutePath()+"�ļ��Ѿ�����,���Ƿ�Ҫ�����ļ�(y/n)?");
			String mark = sc.nextLine();
			if(mark.equalsIgnoreCase("y")){
				flag = true;
			}else if(mark.equalsIgnoreCase("n")){
				flag = false;
			}
		}
		if(flag){
			String templatePath = getRootPath(templateTemplate);//�õ�ģ��·��
			String content = TmFileUtil.readFileByLines(templatePath);//����
			content = replaceTemplate(content);
			try {
				FileUtils.writeStringToFile(entityFile.getAbsoluteFile(), content, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	//page����� list.jsp ҳ��
	public static void createPage(){
		//���� java �ļ�
		Boolean flag = false;
		String rootPath = getRootPath(pageDirs);
		File beanFile = new File(rootPath);
     	if(!beanFile.exists())beanFile.mkdirs();
		File entityFile = new File(rootPath, "list.jsp");//����java�ļ� 
		if(!entityFile.exists()){
			flag = true;
		}else{
			Scanner sc = new Scanner(System.in);//entityFile.getAbsolutePath()
			System.out.println(entityFile.getAbsolutePath()+"�ļ��Ѿ�����,���Ƿ�Ҫ�����ļ�(y/n)?");
			String mark = sc.nextLine();
			if(mark.equalsIgnoreCase("y")){
				flag = true;
			}else if(mark.equalsIgnoreCase("n")){
				flag = false;
			}
		}
		if(flag){
			String templatePath = getRootPath(listjspTemplate);//�õ�ģ��·��
			String content = TmFileUtil.readFileByLines(templatePath);//����
			content = replaceTemplate(content);
			try {
				FileUtils.writeStringToFile(entityFile.getAbsoluteFile(), content, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	//Web��:���Ʋ�
	public static void createWeb(){
		//���� java �ļ�
		Boolean flag = false;
		String rootPath = getRootPath(srcDir + webDir);
		File beanFile = new File(rootPath);
     	if(!beanFile.exists())beanFile.mkdirs();
		File entityFile = new File(rootPath, beanName+"Controller"+".java");//����java�ļ� 
		if(!entityFile.exists()){
			flag = true;
		}else{
			Scanner sc = new Scanner(System.in);//entityFile.getAbsolutePath()
			System.out.println(entityFile.getAbsolutePath()+"�ļ��Ѿ�����,���Ƿ�Ҫ�����ļ�(y/n)?");
			String mark = sc.nextLine();
			if(mark.equalsIgnoreCase("y")){
				flag = true;
			}else if(mark.equalsIgnoreCase("n")){
				flag = false;
			}
		}
		if(flag){
			String templatePath = getRootPath(webTemplate);//�õ�ģ��·��
			String content = TmFileUtil.readFileByLines(templatePath);//����
			content = replaceTemplate(content);
			try {
				FileUtils.writeStringToFile(entityFile.getAbsoluteFile(), content, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	//ServiceImpl��serviceʵ�ֲ�
	public static void createServiceImpl(){
		//���� java �ļ�
		Boolean flag = false;
		String rootPath = getRootPath(srcDir + serviceImplDir);
		File beanFile = new File(rootPath);
     	if(!beanFile.exists())beanFile.mkdirs();
		File entityFile = new File(rootPath, beanName+"ServiceImpl"+".java");//����java�ļ� 
		if(!entityFile.exists()){
			flag = true;
		}else{
			Scanner sc = new Scanner(System.in);
			System.out.println(entityFile.getAbsolutePath()+"�ļ��Ѿ�����,���Ƿ�Ҫ�����ļ�(y/n)?");
			String mark = sc.nextLine();
			if(mark.equalsIgnoreCase("y")){
				flag = true;
			}else if(mark.equalsIgnoreCase("n")){
				flag = false;
			}
		}
		if(flag){
			String templatePath = getRootPath(serviceImplTemplate);//�õ�ģ��·��
			String content = TmFileUtil.readFileByLines(templatePath);//����
			content = replaceTemplate(content);
			try {
				FileUtils.writeStringToFile(entityFile.getAbsoluteFile(), content, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	//service��Ľӿ�
	public static void createService(){
		//���� java �ļ�
		Boolean flag = false;
		String rootPath = getRootPath(srcDir + serviceDir +"/"+beanNameLower);
		File beanFile = new File(rootPath);
     	if(!beanFile.exists())beanFile.mkdirs();
		File entityFile = new File(rootPath,"I"+beanName+"Service"+".java");//����java�ļ� 
		if(!entityFile.exists()){
			flag = true;
		}else{
			Scanner sc = new Scanner(System.in);
			System.out.println(entityFile.getAbsolutePath()+"�ļ��Ѿ�����,���Ƿ�Ҫ�����ļ�(y/n)?");
			String mark = sc.nextLine();
			if(mark.equalsIgnoreCase("y")){
				flag = true;
			}else if(mark.equalsIgnoreCase("n")){
				flag = false;
			}
		}
		if(flag){
			String templatePath = getRootPath(serviceTemplate);//�õ�ģ��·��
			String content = TmFileUtil.readFileByLines(templatePath);//����
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
		//���� java �ļ�
		Boolean flag = false;
		String rootPath = getRootPath(srcDir + daoDir +"/"+beanNameLower);
		File beanFile = new File(rootPath);
     	if(!beanFile.exists())beanFile.mkdirs();
		File entityFile = new File(rootPath,beanName+".xml");//����java�ļ� 
		if(!entityFile.exists()){
			flag = true;
		}else{
			Scanner sc = new Scanner(System.in);
			System.out.println(entityFile.getAbsolutePath()+"�ļ��Ѿ�����,���Ƿ�Ҫ�����ļ�(y/n)?");
			String mark = sc.nextLine();
			if(mark.equalsIgnoreCase("y")){
				flag = true;
			}else if(mark.equalsIgnoreCase("n")){
				flag = false;
			}
		}
		if(flag){
			String templatePath = getRootPath(sqlxmlTemplate);//�õ�ģ��·��
			String content = TmFileUtil.readFileByLines(templatePath);//����
			content = replaceTemplate(content);
			try {
				FileUtils.writeStringToFile(entityFile.getAbsoluteFile(), content, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	//dao(mapper�ӿ�)
	public static void createDao(){
		//���� java �ļ�
		Boolean flag = false;
		String rootPath = getRootPath(srcDir + daoDir +"/"+beanNameLower);
		File beanFile = new File(rootPath);
     	if(!beanFile.exists())beanFile.mkdirs();
		File entityFile = new File(rootPath,"I"+beanName+"Mapper"+".java");//����java�ļ� 
		if(!entityFile.exists()){
			flag = true;
		}else{
			Scanner sc = new Scanner(System.in);
			System.out.println(entityFile.getAbsolutePath()+"�ļ��Ѿ�����,���Ƿ�Ҫ�����ļ�(y/n)?");
			String mark = sc.nextLine();
			if(mark.equalsIgnoreCase("y")){
				flag = true;
			}else if(mark.equalsIgnoreCase("n")){
				flag = false;
			}
		}
		if(flag){
			String templatePath = getRootPath(mapperTemplate);//�õ�ģ��·��
			String content = TmFileUtil.readFileByLines(templatePath);//����
			content = replaceTemplate(content);
			try {
				FileUtils.writeStringToFile(entityFile.getAbsoluteFile(), content, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//�޸��б� ��ģ�壺 beanTemplate��������beanName�� Ŀ¼��beanDir��
	//��������src �µ�Ŀ¼����������Ŀ¼��ȥ�� : srcDir
	public static void createBean(){
		//���� java �ļ�
		Boolean flag = false;
		String rootPath = getRootPath(srcDir + beanDir);
		File beanFile = new File(rootPath);
		if(!beanFile.exists())beanFile.mkdirs();
		File entityFile = new File(rootPath,beanName+".java");//����java�ļ� 
		
		if(!entityFile.exists()){
			flag = true;
		}else{
			Scanner sc = new Scanner(System.in);
			System.out.println(entityFile.getAbsolutePath()+"�ļ��Ѿ�����,���Ƿ�Ҫ�����ļ�(y/n)?");
			String mark = sc.nextLine();
			if(mark.equalsIgnoreCase("y")){
				flag = true;
			}else if(mark.equalsIgnoreCase("n")){
				flag = false;
			}
		}
		if(flag){
			String templatePath = getRootPath(beanTemplate);//�õ�ģ��·��
			String content = TmFileUtil.readFileByLines(templatePath);//����
			content = replaceTemplate(content);
			try {
				FileUtils.writeStringToFile(entityFile.getAbsoluteFile(), content, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	//�滻 
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
	//������
	public static String getPackage(String dirPath){
		
		return  dirPath.replaceAll("/", ".");
	}
	
	//��ȡ·��
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
		System.out.println("�������������");
	}
}
