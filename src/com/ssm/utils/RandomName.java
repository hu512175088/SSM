package com.ssm.utils;

/**
 * 随机生成英文名
 * @author Arthas
 */
public abstract class RandomName {

	public static String randomName() {
		StringBuilder name = new StringBuilder();
		String[] eng = {"a","b","c","d","e","f","g","h","i","j"
				,"k","l","m","n","o","p","q","r","s","t","u","v"
				,"w","y","z"};
		for (int i = 0; i < 2; i++) {
			int e1 = (int) Math.floor(Math.random() * eng.length);
			name.append(eng[e1].toUpperCase());
			int e1Nums = (int) Math.floor(Math.random() * 10);
			while (e1Nums < 4) {
				e1Nums = (int) Math.floor(Math.random() * 10);
			}
			for (int j = 0; j < e1Nums; j++) {
				int e1num = (int) Math.floor(Math.random() * eng.length);
				name.append(eng[e1num]);
			}
			name.append(" ");
		}
		return name.toString();
	}
}
