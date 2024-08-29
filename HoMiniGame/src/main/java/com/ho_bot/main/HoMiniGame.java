package com.ho_bot.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.ho_bot.command.HMG_Cmd;
import com.ho_bot.event.HMG_Event;

public class HoMiniGame extends JavaPlugin {
	
public static HoMiniGame inst;
	
	public void onEnable() {
		inst = this;
		
		Bukkit.getConsoleSender().sendMessage("HoMiniGame Online");
        
		HMG_Event.setPlugin(this);
        getServer().getPluginManager().registerEvents(new HMG_Event(), this);
        
        getCommand("hmg").setExecutor(new HMG_Cmd());
        
        getConfig().options().copyDefaults(true);
        saveConfig();
	}

}
