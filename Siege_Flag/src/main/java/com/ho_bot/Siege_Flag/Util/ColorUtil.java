package com.ho_bot.Siege_Flag.Util;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.boss.BarColor;

public class ColorUtil {
	
	public List<String> ColorList() {
		List<String> colorlist = new ArrayList<String>();
		colorlist.add("Red");
		colorlist.add("Yellow");
		colorlist.add("Green");
		colorlist.add("Blue");
		colorlist.add("Purple");
		colorlist.add("Pink");
		colorlist.add("White");
		return colorlist;
	}
	
	public ChatColor returnChatColor(String string) {
		if(string.equalsIgnoreCase("Red")) {
			return ChatColor.RED;
		}
		else if(string.equalsIgnoreCase("Green")) {
			return ChatColor.GREEN;
		}
		else if(string.equalsIgnoreCase("Pink")) {
			return ChatColor.LIGHT_PURPLE;
		}
		else if(string.equalsIgnoreCase("Purple")) {
			return ChatColor.DARK_PURPLE;
		}
		else if(string.equalsIgnoreCase("Blue")) {
			return ChatColor.BLUE;
		}
		else if(string.equalsIgnoreCase("White")) {
			return ChatColor.WHITE;
		}
		else if(string.equalsIgnoreCase("Yellow")) {
			return ChatColor.YELLOW;
		}
		return null;
	}
	
	public BarColor returnBarColor(String string) {
		if(string.equalsIgnoreCase("Red")) {
			return BarColor.RED;
		}
		else if(string.equalsIgnoreCase("Green")) {
			return BarColor.GREEN;
		}
		else if(string.equalsIgnoreCase("Pink")) {
			return BarColor.PINK;
		}
		else if(string.equalsIgnoreCase("Purple")) {
			return BarColor.PURPLE;
		}
		else if(string.equalsIgnoreCase("Blue")) {
			return BarColor.BLUE;
		}
		else if(string.equalsIgnoreCase("White")) {
			return BarColor.WHITE;
		}
		else if(string.equalsIgnoreCase("Yellow")) {
			return BarColor.YELLOW;
		}
		return null;
	}
	
	public Material returnBlockColor(String string) {
		if(string.equalsIgnoreCase("Red")) {
			return Material.RED_CONCRETE;
		}
		else if(string.equalsIgnoreCase("Green")) {
			return Material.GREEN_CONCRETE;
		}
		else if(string.equalsIgnoreCase("Pink")) {
			return Material.PINK_CONCRETE;
		}
		else if(string.equalsIgnoreCase("Purple")) {
			return Material.PURPLE_CONCRETE;
		}
		else if(string.equalsIgnoreCase("Blue")) {
			return Material.BLUE_CONCRETE;
		}
		else if(string.equalsIgnoreCase("White")) {
			return Material.WHITE_CONCRETE;
		}
		else if(string.equalsIgnoreCase("Yellow")) {
			return Material.YELLOW_CONCRETE;
		}
		return null;
	}
	
	public String returnColorName(String string) {
		if(string.equalsIgnoreCase("Red")) {
			return "빨간색";
		}
		else if(string.equalsIgnoreCase("Green")) {
			return "초록색";
		}
		else if(string.equalsIgnoreCase("Pink")) {
			return "분홍색";
		}
		else if(string.equalsIgnoreCase("Purple")) {
			return "보라색";
		}
		else if(string.equalsIgnoreCase("Blue")) {
			return "파란색";
		}
		else if(string.equalsIgnoreCase("White")) {
			return "흰색";
		}
		else if(string.equalsIgnoreCase("Yellow")) {
			return "노란색";
		}
		return null;
	}

}
