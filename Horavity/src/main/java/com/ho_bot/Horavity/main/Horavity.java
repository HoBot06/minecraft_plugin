package com.ho_bot.Horavity.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.ho_bot.Horavity.event.HO_Event;

public class Horavity extends JavaPlugin{
	
	public static Horavity inst;
	
	@Override
	public void onEnable() {
		inst = this;
		
		Bukkit.getConsoleSender().sendMessage("[Horavity] " + this.getDescription().getVersion() + " Online");
		
		HO_Event.setPlugin(this);
		getServer().getPluginManager().registerEvents(new HO_Event(), this);
	}

}
