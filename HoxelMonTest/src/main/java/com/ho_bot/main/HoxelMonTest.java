package com.ho_bot.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

import com.ho_bot.cmd.Ho_Cmd;
import com.ho_bot.event.Ho_Event;
import com.ho_bot.event.PixelEvent;

public class HoxelMonTest extends JavaPlugin{
	
	public static HoxelMonTest inst;
	
	private PixelEvent pixelE = new PixelEvent();
	
	@Override
	public void onEnable() {
		inst = this;
		
		Bukkit.getConsoleSender().sendMessage("HoxelMonTest " + getDescription().getVersion() + " Online");
		ModRegister();
		
		getServer().getPluginManager().registerEvents(new Ho_Event(), this);
		getCommand("hoxelmon").setExecutor(new Ho_Cmd());
		getCommand("hoxelmon").setTabCompleter(new Ho_Cmd());
		
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
	}
	
	private void ModRegister() {
		Bukkit.getServicesManager().register(PixelEvent.class, new PixelEvent(), this, ServicePriority.Normal);
		Bukkit.getPluginManager().registerEvents(new PixelEvent(), this);
		this.pixelE.register(inst);
	}

}
