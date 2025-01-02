package com.ho_bot.HoName.manager;

import org.bukkit.ChatColor;

public class SimpleNameTag implements NameTag{
	
	private String text;

    SimpleNameTag(String text) {
        this.text = ChatColor.translateAlternateColorCodes('&', text);
    }

    public String getText() {
        return this.text;
    }

}
