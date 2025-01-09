package com.ho_bot.DontBreak.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.ho_bot.DontBreak.cmd.DB_Cmd;
import com.ho_bot.DontBreak.event.DB_Event;
import com.ho_bot.DontBreak.file.ConfigFile;
import com.ho_bot.DontBreak.file.LocFile;

public class DontBreak extends JavaPlugin {
	
	public static DontBreak inst;
	
	private ConfigFile configF = new ConfigFile();
	private LocFile locF = new LocFile();
	
	@Override
	public void onEnable() {
		inst = this;
		Bukkit.getConsoleSender().sendMessage("DontBreak " + getDescription().getVersion() + " Online");
        
		DB_Event.setPlugin(this);
        getServer().getPluginManager().registerEvents(new DB_Event(), this);
		
        getCommand("DontBreak").setExecutor(new DB_Cmd());
        getCommand("DontBreak").setTabCompleter(new DB_Cmd());
        
        getConfig().options().copyDefaults(true);
        saveConfig();
		
        configF.reloadConfig();
        locF.reloadLocFile();
	}

}
