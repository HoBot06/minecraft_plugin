package com.ho_bot.AntWar;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class AntWar extends JavaPlugin{
	
	public void OnEnable() {
		Bukkit.getConsoleSender().sendMessage("AntWar v1.0 Online");
        
        AntWarEvent.setPlugin(this);
        getServer().getPluginManager().registerEvents(new AntWarEvent(), this);
        
        getCommand("AntWar").setExecutor(new AntWarCommand());
        getCommand("AntWar").setTabCompleter(new AntWarTabCommand());
	}
	
	public void onDisable() {
		
	}

}
