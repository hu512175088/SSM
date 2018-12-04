package com.ssm.utils;

/**
 * 随机生成指定位数的数字
 * @author Arthas
 *
 */
public class RandomNums {

	/**
	 * @param length : 指定长度
	 * @return
	 */
	public static String getNums(int length) {
		StringBuilder nums = new StringBuilder();
		for (int i = 0; i < length; i++) {
			nums.append((int) Math.ceil(Math.random() * length));
		}
		return nums.toString();
	}
}
