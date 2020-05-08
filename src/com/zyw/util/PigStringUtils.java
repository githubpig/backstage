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
	 * 空判断
	 * 方法名:isEmpty
	 * 创建人:piggy	时间:2017年2月9日-下午2:26:39
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
	 * 非空判断
	 * 方法名:isNotEmpty
	 * 创建人:piggy	时间:2017年2月9日-下午2:26:57
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
	
	/*作用:String类型转换为日期
	  format形式：											strDate:
	 	yyyy年MM月dd日 HH时mm分ss秒									2004年12月16日 17时24分27秒
		yy/MM/dd HH:mm											04/12/16 17:24
		yyyy-MM-dd HH:mm:ss
		yyyy年MM月dd日 HH时mm分ss秒 E								2004年12月16日 17时24分27秒 星期四 
		"一年中的第 D 天 一年中第w个星期 一月中第W个星期 在一天中k时 z时区"
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
	
	
	/*作用:日期转换为String类型
	  format形式：
	 	yyyy年MM月dd日 HH时mm分ss秒
		yy/MM/dd HH:mm
		yyyy-MM-dd HH:mm:ss
		yyyy年MM月dd日 HH时mm分ss秒 E
		"一年中的第 D 天 一年中第w个星期 一月中第W个星期 在一天中k时 z时区"
	 */
	public static String datetoString(Date date,String format){
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	/**
	 * 邮箱的判定
	 * 方法名:isEmail
	 * 创建人:piggy	时间:2017年2月27日-上午1:59:00
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
	 * 手机号的判定
	 * 方法名:isMobile
	 * 创建人:piggy	时间:2017年2月27日-上午1:59:41
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
	 * 判断字符串是否都是英文字母组成
	 * 方法名:isEnglish
	 * 创建人:piggy	时间:2017年2月27日-上午2:01:20
	 * @param string
	 * @return boolean
	 */
	public static boolean isEnglish(String string) {
		return StringUtils.isAlpha(string);
	}
	/**
	 * 字母或数字
	 * 方法名:isEnglishOrNumber
	 * 创建人:piggy	时间:2017年2月27日-上午2:06:47
	 * @param numEnglishString
	 * @return boolean
	 */
	public static boolean isEnglishOrNumber(String numEnglishString) {
		return StringUtils.isAlphanumeric(numEnglishString);
	}
	
	/**
	 * 
	 * 方法名:conversionSpecialCharacters
	 * 创建人:piggy	时间:2017年3月5日-上午1:44:34
	 * @param string
	 * @return String
	 */
	public static String conversionSpecialCharacters(String string) {
		return string.replaceAll("\\\\", "/");
	}
	
	/**
	 * 获取文件名后缀
	 * 方法名:getSuffix
	 * 创建人:piggy	时间:2017年3月14日-下午1:32:26
	 * @param fileName :文件名
	 * @param flag true:有点，false:没点
	 * @return String 
	 */
	public static String getFnameSuffix(String fileName,Boolean flag){
		//文件名后缀
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
	
	// 为上传文件自动分配文件名称，避免重复
	public static String generateFileName(String fileName,int randomNum,String dataPattern) {
		// 获得当前时间
		DateFormat format = new SimpleDateFormat(dataPattern);
		// 转换为字符串
		String formatDate = format.format(new Date());
		// 随机生成文件编号
		int random = new Random().nextInt(randomNum);
		// 获得文件后缀名称
		int position = fileName.lastIndexOf(".");
		String extension = fileName.substring(position);
		// 组成一个新的文件名称
		return formatDate + random + extension;
	}
	
	
	/**
	 * 根据File文件的长度统计文件的大小
	 * 
	 * @param size
	 *            File的长度 file.lenght()
	 * @return 返回文件大小
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
	 * 判断是否是JSON字符串
	 * 方法名:isGoodJson
	 * 创建人:piggy	时间:2017年3月15日-下午9:56:24
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
		
//		String Jsonstr = "{'name':'zyw','address':'漯河'}";
//		String Jsonstr1 = "{\"name\":\"zyw\",\"address\":\"漯河\"}";
//		String Jsonstr2 = "sfagrshrdtjfkutyjre";
//		System.out.println(isGoodJson(Jsonstr)+"-----"+isGoodJson(Jsonstr2));
		
		//System.out.println(PigStringUtils.isEnglishOrNumber("O@wert21356545786"));
		
		//System.out.println(PigStringUtils.isEnglish("wqertrytukuyr"));
		
		//		System.out.println(PigStringUtils.isMobile("15237360630"));
		//		System.out.println(PigStringUtils.isMobile("11111111111"));
		
//		System.out.println(PigStringUtils.isEmail("357076478@qq.com"));
		
		
//		Date d = new Date();
//		System.out.println(datetoString(d,"yyyy-MM-dd"));
//		System.out.println(StringtoDate("2004年12月16日 17时24分27秒","yyyy年MM月dd日 HH时mm分ss秒"));
		
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
