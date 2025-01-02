package com.ho_bot.HoName.event;

import org.bukkit.event.Listener;

import com.ho_bot.HoName.main.HoName;

public class HN_Event implements Listener{
	
	public static HoName plugin;

	public static void setPlugin(HoName MainPlugin)
    {
        plugin = MainPlugin;
    }

}
