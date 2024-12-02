package com.ho_bot.Horavity.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.ho_bot.Horavity.event.HO_Event;
import com.ho_bot.Horavity.timer.GravityTimer;

public class Horavity extends JavaPlugin{
	
	public Horavity inst;
	
	@Override
	public void onEnable() {
		inst = this;
		
		Bukkit.getConsoleSender().sendMessage("[Horavity] " + this.getDescription().getVersion() + " Online");
		
		HO_Event.setPlugin(this);
		getServer().getPluginManager().registerEvents(new HO_Event(), this);
		
		GravityTimer gravityT = new GravityTimer();
		gravityT.runTaskTimer(this, 0L, 1L);
	}

}
