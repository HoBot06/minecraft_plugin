package com.ho_bot.HB_Rune.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.ho_bot.HB_Rune.cmd.HB_Cmd;
import com.ho_bot.HB_Rune.event.HB_Event;

public class HB_Rune extends JavaPlugin {
	
	public static HB_Rune inst;
	
	public void onEnable() {
		inst = this;
		Bukkit.getConsoleSender().sendMessage("HB_Rune "+getDescription().getVersion()+" Online");
		
		HB_Event.setPlugin(this);
        getServer().getPluginManager().registerEvents(new HB_Event(), this);
        
        getCommand("룬").setExecutor(new HB_Cmd());
        getCommand("룬").setTabCompleter(new HB_Cmd());
        
        getConfig().options().copyDefaults(true);
        saveConfig();
        
	}
	
	public void onDisable() {
		
	}

}
