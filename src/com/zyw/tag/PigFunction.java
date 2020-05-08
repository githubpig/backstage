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
	 * ���ڸ�ʽ����ע�ᵽtld�ļ���
	 * ������:formatDate
	 * ������:piggy	ʱ��:2017��2��20��-����9:56:59
	 * @param date
	 * @param format
	 * @return String
	 */
	public static String formatDate(Date date,String format){
		return PigStringUtils.datetoString(date, format);
	}
	
	/**
	 * ��ȡ���ϵĳ���
	 * ������:getLength
	 * ������:piggy	ʱ��:2017��2��20��-����10:12:05
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
	 * ���۷���ʱ��
	 * ������:getTimeFormat
	 * ������:piggy	ʱ��:2017��2��22��-����6:57:58
	 * @param startTime
	 * @return String
	 */
	public static String getTimeFormat(Date startTime){
		try{
			long startTimeMills = startTime.getTime();
			long endTimeMills = System.currentTimeMillis();
			long diff = (endTimeMills - startTimeMills)/1000;//��
			long day_diff  = (long) Math.floor(diff/86400);//��
			StringBuffer buffer = new StringBuffer();
			if(day_diff<0){
				return "[error],ʱ��Խ��...";
			}else{
				if(day_diff==0 && diff<60){
					if(diff==0)diff=1;
					buffer.append(diff+"��ǰ");
				}else if(day_diff==0 && diff<120){
					buffer.append("1 ����ǰ");
				}else if(day_diff==0 && diff<3600){
					buffer.append(Math.round(Math.floor(diff/60))+"����ǰ");
				}else if(day_diff==0 && diff<7200){
					buffer.append("1Сʱǰ");
				}else if(day_diff==0 && diff<86400){
					buffer.append(Math.round(Math.floor(diff/3600))+"Сʱǰ");
				}else if(day_diff==1){
					buffer.append("1��ǰ");
				}else if(day_diff<7){
					buffer.append(day_diff+"��ǰ");
				}else if(day_diff <30){
					buffer.append(Math.round(Math.ceil( day_diff / 7 )) + " ����ǰ");
				}else if(day_diff >=30 && day_diff<=179 ){
					buffer.append(Math.round(Math.ceil( day_diff / 30 )) + "��ǰ");
				}else if(day_diff >=180 && day_diff<365){
					buffer.append("����ǰ");
				}else if(day_diff>=365){
					buffer.append(Math.round(Math.ceil( day_diff /30/12))+"��ǰ");
				}
			}
			return buffer.toString();
		}catch(Exception ex){
			return "";
		}
	}
	
	/**
	 * �������ֻ�ȡ����
	 * com.tz.tld 
	 * ��������getCharacter
	 * �����ˣ�xuchengfei 
	 * �ֻ�����:15074816437
	 * ʱ�䣺2015��9��15��-����10:46:36 
	 * @return 
	 * �������ͣ�String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String getCharacter(int num){
		return String.valueOf((char)(64+num));
	}
	
	/**
	 * ������ת���ɶ�Ӧ������
	 * ��������intToChnNumConverter<BR>
	 * �����ˣ�̶��ѧԺ-keke <BR>
	 * ʱ�䣺2014��11��11��-����10:33:30 <BR>
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
	    chnNumbers.put(0, "��");
	    chnNumbers.put(1, "һ");
	    chnNumbers.put(2, "��");
	    chnNumbers.put(3, "��");
	    chnNumbers.put(4, "��");
	    chnNumbers.put(5, "��");
	    chnNumbers.put(6, "��");
	    chnNumbers.put(7, "��");
	    chnNumbers.put(8, "��");
	    chnNumbers.put(9, "��");
	 
	    HashMap unitMap = new HashMap();
	    unitMap.put(1, "");
	    unitMap.put(10, "ʮ");
	    unitMap.put(100, "��");
	    unitMap.put(1000, "ǧ");
	    int[] unitArray = {1000, 100, 10, 1};
	 
	    StringBuilder result = new StringBuilder();
	    int i = 0;
	    while(num > 0){
	        int n1 = num / unitArray[i];
	        if(n1 > 0){
	            result.append(chnNumbers.get(n1)).append(unitMap.get(unitArray[i]));
	        }
	        if(n1 == 0){
	            if(result.lastIndexOf("��") != result.length()-1){
	                result.append("��");
	            }
	        }
	        num = num % unitArray[i++];
	        if(num == 0){
	            break;
	        }
	    }
	    resultNumber = result.toString();
	    if(resultNumber.startsWith("��")){
	        resultNumber = resultNumber.substring(1);
	    }
	    if(resultNumber.startsWith("һʮ")){
	        resultNumber = resultNumber.substring(1);
	    }
	    return resultNumber;
	}
	/**
	 * ������ת����Ǯ����ʽ ��ȷ��С����2λ
	 * ������:getMoney
	 * ������:piggy	ʱ��:2017��3��5��-����12:57:09
	 * @param money
	 * @return String
	 */
	public static String getMoney(Double money){
		Trans2RMB t2r = new Trans2RMB();
		String s = t2r.cleanZero(t2r.splitNum(t2r.roundString(String.valueOf(money))));
		return s;
	}
	
	/**
	 * ��ȡip��Ӧ�ĳ�����Ϣ
	 * ������:ipLocation
	 * ������:piggy	ʱ��:2017��3��5��-����2:03:20
	 * @param ip
	 * @return String
	 */
	public static String ipLocation(String ip){
		if(PigStringUtils.isEmpty(ip)) ip = "����";
		return TmIpUtil.ipLocation(ip);
	}
	
	//�ж��ַ����Ƿ����Ӵ�,����ֵ�ǵ�һ�γ����ַ����±�
	public static int indexOf(String content,String sub){
		return content.indexOf(sub);
	}
	
	public static void main(String[] args) {
		System.out.println(indexOf("bc","abbbbbbc"));
		//System.out.println(hiddenPhone("15237360630",3,4));
		//System.out.println(getMoney(11125.456));
	}
}
