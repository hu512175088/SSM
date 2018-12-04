package com.ssm.utils;

/**
 * 按照规定的格式生成日期
 * @author Arthas
 *
 */
public class RandomDate {

	/**
	 * @param startYear : 开始时间,比如 1997
	 * @param endYear : 结束时间,比如2008
	 * @return
	 */
	public static String getDate(int startYear, int endYear) {
		String date = null;
		int year = (int) Math.floor(Math.random() * endYear);
		while (year < startYear) {
			year = (int) Math.floor(Math.random() * endYear);
		}
		int month = (int) Math.ceil(Math.random() * 12);
		int day = (int) Math.ceil(Math.random() * 31);
		date = year + "-" + month + "-" + day;
		return date;
	}
}
