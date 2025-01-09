package com.ho_bot.HB_Rune.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class LogUtil {
	
	private static final String prefix = ChatColor.AQUA + "[HB_Rune] "+ChatColor.GRAY;

    public static void info(String msg) {
        Bukkit.getConsoleSender().sendMessage(prefix + msg);
    }

}
