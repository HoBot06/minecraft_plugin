package com.ho_bot.HoEatAll.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.ho_bot.HoEatAll.cmd.Ho_Cmd;

public class HoEatAll extends JavaPlugin {
	
	public static HoEatAll inst;
	
	@Override
	public void onEnable() {
		inst = this;
		
		Bukkit.getConsoleSender().sendMessage("HoEatAll "+getDescription().getVersion()+" Online");
        
		getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        
        getCommand("HoEatAll").setExecutor(new Ho_Cmd());
        getCommand("HoEatAll").setTabCompleter(new Ho_Cmd());
	}

}
