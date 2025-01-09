package com.ho_bot.DontBreak.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class DontBreak extends JavaPlugin {
	
	public static DontBreak inst;
	
	@Override
	public void onEnable() {
		inst = this;
		Bukkit.getConsoleSender().sendMessage("DontBreak " + getDescription().getVersion() + " Online");
        
        getConfig().options().copyDefaults(true);
        saveConfig();
		
	}

}
