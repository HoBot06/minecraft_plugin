package com.ho_bot.ApiGame.util;

import java.util.concurrent.ThreadLocalRandom;

public class NumUtil {
	
	public int getRandNum(String str) {
		String[] s_s = str.split("~");
		if(s_s.length > 1) {
			int num1 = Integer.parseInt(s_s[0]);
			int num2 = Integer.parseInt(s_s[1]);
			int r_num = ThreadLocalRandom.current().nextInt(num1, num2+1);
			return r_num;
		}
		else {
			return Integer.parseInt(str);
		}
	}

}
