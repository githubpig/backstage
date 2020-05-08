package com.zyw.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import Decoder.BASE64Encoder;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class PigStringUtils {
	
	/**
	 * ���ж�
	 * ������:isEmpty
	 * ������:piggy	ʱ��:2017��2��9��-����2:26:39
	 * @param content
	 * @return boolean
	 */
	public static boolean isEmpty(String content){
//		if(content == null || content.equals("")){
//			return true;
//		}else{
//			return false;s
//		}
		return (content == null || content.equals(""))?true:false;
	}
	
	/**
	 * �ǿ��ж�
	 * ������:isNotEmpty
	 * ������:piggy	ʱ��:2017��2��9��-����2:26:57
	 * @param content
	 * @return boolean
	 */
	public static boolean isNotEmpty(String content){
		return !isEmpty(content);
	}
	
	public static String base64Encode(byte[] b) {
		if (b == null) {
			return null;
		}
		return new BASE64Encoder().encode(b);
	}
	
	public static String md5Base64(String str) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			return base64Encode(md5.digest(str.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String formatDate(Date date,String pattern){
		if(date!=null){
			String dateString = new SimpleDateFormat(pattern).format(date);
			return dateString;
		}else{
			return "";
		}
	}
	
	/*����:String����ת��Ϊ����
	  format��ʽ��											strDate:
	 	yyyy��MM��dd�� HHʱmm��ss��									2004��12��16�� 17ʱ24��27��
		yy/MM/dd HH:mm											04/12/16 17:24
		yyyy-MM-dd HH:mm:ss
		yyyy��MM��dd�� HHʱmm��ss�� E								2004��12��16�� 17ʱ24��27�� ������ 
		"һ���еĵ� D �� һ���е�w������ һ���е�W������ ��һ����kʱ zʱ��"
	 */
	public static Date StringtoDate(String strDate,String format){
		try {
			SimpleDateFormat df1 = new SimpleDateFormat(format);
			Date d=df1.parse(strDate);
			return d;
		} catch (Exception e) {
			return null;
		}
	}
	
	
	/*����:����ת��ΪString����
	  format��ʽ��
	 	yyyy��MM��dd�� HHʱmm��ss��
		yy/MM/dd HH:mm
		yyyy-MM-dd HH:mm:ss
		yyyy��MM��dd�� HHʱmm��ss�� E
		"һ���еĵ� D �� һ���е�w������ һ���е�W������ ��һ����kʱ zʱ��"
	 */
	public static String datetoString(Date date,String format){
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	/**
	 * ������ж�
	 * ������:isEmail
	 * ������:piggy	ʱ��:2017��2��27��-����1:59:00
	 * @param email
	 * @return boolean
	 */
	public static boolean isEmail(String email) {
		boolean flag = false;
		try {
			String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(email);
			flag = matcher.matches();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	/**
	 * �ֻ��ŵ��ж�
	 * ������:isMobile
	 * ������:piggy	ʱ��:2017��2��27��-����1:59:41
	 * @param mobiles
	 * @return boolean
	 */
	public static boolean isMobile(String mobiles) {
		boolean flag = false;
		try {
			Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
			Matcher m = p.matcher(mobiles);
			flag = m.matches();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	/**
	 * �ж��ַ����Ƿ���Ӣ����ĸ���
	 * ������:isEnglish
	 * ������:piggy	ʱ��:2017��2��27��-����2:01:20
	 * @param string
	 * @return boolean
	 */
	public static boolean isEnglish(String string) {
		return StringUtils.isAlpha(string);
	}
	/**
	 * ��ĸ������
	 * ������:isEnglishOrNumber
	 * ������:piggy	ʱ��:2017��2��27��-����2:06:47
	 * @param numEnglishString
	 * @return boolean
	 */
	public static boolean isEnglishOrNumber(String numEnglishString) {
		return StringUtils.isAlphanumeric(numEnglishString);
	}
	
	/**
	 * 
	 * ������:conversionSpecialCharacters
	 * ������:piggy	ʱ��:2017��3��5��-����1:44:34
	 * @param string
	 * @return String
	 */
	public static String conversionSpecialCharacters(String string) {
		return string.replaceAll("\\\\", "/");
	}
	
	/**
	 * ��ȡ�ļ�����׺
	 * ������:getSuffix
	 * ������:piggy	ʱ��:2017��3��14��-����1:32:26
	 * @param fileName :�ļ���
	 * @param flag true:�е㣬false:û��
	 * @return String 
	 */
	public static String getFnameSuffix(String fileName,Boolean flag){
		//�ļ�����׺
		if(isNotEmpty(fileName)){
			String nameSuffix;
			if(flag){
				nameSuffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
				return nameSuffix;
			}else{
				nameSuffix = fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
				return nameSuffix;
			}
			
		}else{
			return null;
		}
	}
	
	// Ϊ�ϴ��ļ��Զ������ļ����ƣ������ظ�
	public static String generateFileName(String fileName,int randomNum,String dataPattern) {
		// ��õ�ǰʱ��
		DateFormat format = new SimpleDateFormat(dataPattern);
		// ת��Ϊ�ַ���
		String formatDate = format.format(new Date());
		// ��������ļ����
		int random = new Random().nextInt(randomNum);
		// ����ļ���׺����
		int position = fileName.lastIndexOf(".");
		String extension = fileName.substring(position);
		// ���һ���µ��ļ�����
		return formatDate + random + extension;
	}
	
	
	/**
	 * ����File�ļ��ĳ���ͳ���ļ��Ĵ�С
	 * 
	 * @param size
	 *            File�ĳ��� file.lenght()
	 * @return �����ļ���С
	 */
	public static String countFileSize(long fileSize) {
		String fileSizeString = "";
		try {
			DecimalFormat df = new DecimalFormat("#.00");
			long fileS = fileSize;
			if (fileS == 0) {
				fileSizeString = "0KB";
			} else if (fileS < 1024) {
				fileSizeString = df.format((double) fileS) + "B";
			} else if (fileS < 1048576) {
				fileSizeString = df.format((double) fileS / 1024) + "KB";
			} else if (fileS < 1073741824) {
				fileSizeString = df
						.format(((double) fileS / 1024 / 1024) - 0.01)
						+ "MB";
			} else {
				fileSizeString = df.format((double) fileS / 1024 / 1024 / 1024)
						+ "G";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileSizeString;
	}
	
	/**
	 * �ж��Ƿ���JSON�ַ���
	 * ������:isGoodJson
	 * ������:piggy	ʱ��:2017��3��15��-����9:56:24
	 * @param json
	 * @return boolean
	 */
	public static boolean isGoodJson(String json) {    
		try {
			JsonElement je =new JsonParser().parse(json); 
		     return true; 
		} catch (Exception e) {
		  System.out.println("bad json: " + json);    
	      return false;  
		}
	}
	
	
	public static void main(String[] args) {
		
//		String Jsonstr = "{'name':'zyw','address':'���'}";
//		String Jsonstr1 = "{\"name\":\"zyw\",\"address\":\"���\"}";
//		String Jsonstr2 = "sfagrshrdtjfkutyjre";
//		System.out.println(isGoodJson(Jsonstr)+"-----"+isGoodJson(Jsonstr2));
		
		//System.out.println(PigStringUtils.isEnglishOrNumber("O@wert21356545786"));
		
		//System.out.println(PigStringUtils.isEnglish("wqertrytukuyr"));
		
		//		System.out.println(PigStringUtils.isMobile("15237360630"));
		//		System.out.println(PigStringUtils.isMobile("11111111111"));
		
//		System.out.println(PigStringUtils.isEmail("357076478@qq.com"));
		
		
//		Date d = new Date();
//		System.out.println(datetoString(d,"yyyy-MM-dd"));
//		System.out.println(StringtoDate("2004��12��16�� 17ʱ24��27��","yyyy��MM��dd�� HHʱmm��ss��"));
		
//		System.out.println(md5Base64(md5Base64("A8d6kUQTmW0canSOQTUKPg==")));
//		System.out.println(md5Base64("123456"));
//		System.out.println(md5Base64(md5Base64("123456")+"zyw"));
		
//		System.out.println(isEmpty(""));//true
//		System.out.println(isEmpty(null));//true
//		System.out.println(isNotEmpty("null"));//true
//		System.out.println(isNotEmpty(null));//false
//		System.out.println(getSuffix("qwerty.txt",true));
		//System.out.println(UUID.randomUUID().toString());
		//System.out.println(generateFileName("aaa.pdf", 10, "yyMMddHHmmss"));
		
	}
}
