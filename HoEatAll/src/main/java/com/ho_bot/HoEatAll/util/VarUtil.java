package com.ho_bot.HoEatAll.util;

public class VarUtil {

	public static enum ConsumeType{
		none("none");

		private final String string;

		ConsumeType(String string) {
	        this.string = string;
	    }

	    public String toString() {
	        return string;
	    }
	}
	
}
