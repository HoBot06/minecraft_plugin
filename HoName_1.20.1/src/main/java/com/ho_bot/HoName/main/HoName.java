package com.ho_bot.HoName.main;

import org.bukkit.plugin.java.JavaPlugin;

import com.ho_bot.HoName.cmd.HN_Cmd;
import com.ho_bot.HoName.event.HN_Event;
import com.ho_bot.HoName.file.ConfigFile;

public class HoName extends JavaPlugin {
	
	public static HoName inst;
	
	private ConfigFile configF = new ConfigFile();
	
	@Override
	public void onEnable() {
		inst = this;
		
		HN_Event.setPlugin(this);
		getServer().getPluginManager().registerEvents(new HN_Event(), this);
        
        getCommand("HoName").setExecutor(new HN_Cmd());
        getCommand("HoName").setTabCompleter(new HN_Cmd());
        
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        
        configF.reloadConfig();
	}

}
