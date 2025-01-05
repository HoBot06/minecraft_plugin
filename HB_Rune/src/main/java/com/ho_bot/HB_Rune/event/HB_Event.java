package com.ho_bot.HB_Rune.event;

import org.bukkit.event.Listener;

import com.ho_bot.HB_Rune.main.HB_Rune;

public class HB_Event implements Listener {
	
	public static HB_Rune plugin;

	public static void setPlugin(HB_Rune MainPlugin)
    {
        plugin = MainPlugin;
    }

}
