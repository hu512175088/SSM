package com.ssm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * @author zhonglinsen
 *
 */
public class DateUtil {
	
	
	public static String dateToString(Date date,String dateFormat) throws Exception{
		SimpleDateFormat format=new SimpleDateFormat(dateFormat);
		return format.format(date);
	}
	
	public static Date strToDate(String str,String dateFormat) throws Exception{
		SimpleDateFormat format=new SimpleDateFormat(dateFormat);
		return format.parse(str);
	}
}
