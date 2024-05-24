package com.ho_bot.AntWar.Util;

public class ColorUtil {
	
	public enum AntColor {
		WHITE("WHITE"),RED("RED");

		private final String color;
		
		AntColor(String color) {
			this.color = color;
		}
		
		public String getColor() {
			return color;
		}
	}
	
	public static AntColor returnColor(String Color) {
		if (Color.equalsIgnoreCase("RED")) return AntColor.RED;
		else return null;
	}
	
	

}
