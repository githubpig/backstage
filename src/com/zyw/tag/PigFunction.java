package com.zyw.tag;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import com.zyw.util.PigStringUtils;
import com.zyw.util.ip.TmIpUtil;

public class PigFunction {
	
	/* 15237360630 ==> 152XXXXX0630*/
	public static String hiddenPhone(String phone,Integer n,Integer m){
		String beforeStr = phone.substring(0,n);
		int  length = phone.length();
		String lastStr = phone.substring(length-m, length);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<length-n-m;i++){
			sb.append("X");
		}
		String resultPhone = beforeStr + sb.toString() +lastStr;
		return resultPhone;
	}
	/**
	 * 日期格式化并注册到tld文件中
	 * 方法名:formatDate
	 * 创建人:piggy	时间:2017年2月20日-下午9:56:59
	 * @param date
	 * @param format
	 * @return String
	 */
	public static String formatDate(Date date,String format){
		return PigStringUtils.datetoString(date, format);
	}
	
	/**
	 * 获取集合的长度
	 * 方法名:getLength
	 * 创建人:piggy	时间:2017年2月20日-下午10:12:05
	 * @param collection
	 * @return int
	 */
	public static int getLength(Collection<?> collection){
		if(collection != null){
			return collection.size();
		}else{
			return 0;
		}
	}
	/**
	 * 评论发布时间
	 * 方法名:getTimeFormat
	 * 创建人:piggy	时间:2017年2月22日-下午6:57:58
	 * @param startTime
	 * @return String
	 */
	public static String getTimeFormat(Date startTime){
		try{
			long startTimeMills = startTime.getTime();
			long endTimeMills = System.currentTimeMillis();
			long diff = (endTimeMills - startTimeMills)/1000;//秒
			long day_diff  = (long) Math.floor(diff/86400);//天
			StringBuffer buffer = new StringBuffer();
			if(day_diff<0){
				return "[error],时间越界...";
			}else{
				if(day_diff==0 && diff<60){
					if(diff==0)diff=1;
					buffer.append(diff+"秒前");
				}else if(day_diff==0 && diff<120){
					buffer.append("1 分钟前");
				}else if(day_diff==0 && diff<3600){
					buffer.append(Math.round(Math.floor(diff/60))+"分钟前");
				}else if(day_diff==0 && diff<7200){
					buffer.append("1小时前");
				}else if(day_diff==0 && diff<86400){
					buffer.append(Math.round(Math.floor(diff/3600))+"小时前");
				}else if(day_diff==1){
					buffer.append("1天前");
				}else if(day_diff<7){
					buffer.append(day_diff+"天前");
				}else if(day_diff <30){
					buffer.append(Math.round(Math.ceil( day_diff / 7 )) + " 星期前");
				}else if(day_diff >=30 && day_diff<=179 ){
					buffer.append(Math.round(Math.ceil( day_diff / 30 )) + "月前");
				}else if(day_diff >=180 && day_diff<365){
					buffer.append("半年前");
				}else if(day_diff>=365){
					buffer.append(Math.round(Math.ceil( day_diff /30/12))+"年前");
				}
			}
			return buffer.toString();
		}catch(Exception ex){
			return "";
		}
	}
	
	/**
	 * 根据数字获取索引
	 * com.tz.tld 
	 * 方法名：getCharacter
	 * 创建人：xuchengfei 
	 * 手机号码:15074816437
	 * 时间：2015年9月15日-下午10:46:36 
	 * @return 
	 * 返回类型：String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String getCharacter(int num){
		return String.valueOf((char)(64+num));
	}
	
	/**
	 * 将数字转换成对应的中文
	 * 方法名：intToChnNumConverter<BR>
	 * 创建人：潭州学院-keke <BR>
	 * 时间：2014年11月11日-下午10:33:30 <BR>
	 * @param num
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public static String chinesCharacter(int num){
	    String resultNumber = null;
	    if(num > 10000 || num < 0){
	        return "";
	    }
	    HashMap chnNumbers = new HashMap();
	    chnNumbers.put(0, "零");
	    chnNumbers.put(1, "一");
	    chnNumbers.put(2, "二");
	    chnNumbers.put(3, "三");
	    chnNumbers.put(4, "四");
	    chnNumbers.put(5, "五");
	    chnNumbers.put(6, "六");
	    chnNumbers.put(7, "七");
	    chnNumbers.put(8, "八");
	    chnNumbers.put(9, "九");
	 
	    HashMap unitMap = new HashMap();
	    unitMap.put(1, "");
	    unitMap.put(10, "十");
	    unitMap.put(100, "百");
	    unitMap.put(1000, "千");
	    int[] unitArray = {1000, 100, 10, 1};
	 
	    StringBuilder result = new StringBuilder();
	    int i = 0;
	    while(num > 0){
	        int n1 = num / unitArray[i];
	        if(n1 > 0){
	            result.append(chnNumbers.get(n1)).append(unitMap.get(unitArray[i]));
	        }
	        if(n1 == 0){
	            if(result.lastIndexOf("零") != result.length()-1){
	                result.append("零");
	            }
	        }
	        num = num % unitArray[i++];
	        if(num == 0){
	            break;
	        }
	    }
	    resultNumber = result.toString();
	    if(resultNumber.startsWith("零")){
	        resultNumber = resultNumber.substring(1);
	    }
	    if(resultNumber.startsWith("一十")){
	        resultNumber = resultNumber.substring(1);
	    }
	    return resultNumber;
	}
	/**
	 * 将数字转换成钱的形式 精确到小数点2位
	 * 方法名:getMoney
	 * 创建人:piggy	时间:2017年3月5日-上午12:57:09
	 * @param money
	 * @return String
	 */
	public static String getMoney(Double money){
		Trans2RMB t2r = new Trans2RMB();
		String s = t2r.cleanZero(t2r.splitNum(t2r.roundString(String.valueOf(money))));
		return s;
	}
	
	/**
	 * 获取ip对应的城市信息
	 * 方法名:ipLocation
	 * 创建人:piggy	时间:2017年3月5日-上午2:03:20
	 * @param ip
	 * @return String
	 */
	public static String ipLocation(String ip){
		if(PigStringUtils.isEmpty(ip)) ip = "匿名";
		return TmIpUtil.ipLocation(ip);
	}
	
	//判断字符串是否是子串,返回值是第一次出现字符的下标
	public static int indexOf(String content,String sub){
		return content.indexOf(sub);
	}
	
	public static void main(String[] args) {
		System.out.println(indexOf("bc","abbbbbbc"));
		//System.out.println(hiddenPhone("15237360630",3,4));
		//System.out.println(getMoney(11125.456));
	}
}
