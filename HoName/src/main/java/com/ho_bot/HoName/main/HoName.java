package com.ho_bot.HoName.main;

import org.bukkit.plugin.java.JavaPlugin;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.ho_bot.HoName.cmd.HN_Cmd;
import com.ho_bot.HoName.event.HN_Event;

public class HoName extends JavaPlugin {
	
	public static HoName inst;
	public static ProtocolManager protocolM;
	
	@Override
	public void onEnable() {
		inst = this;
		protocolM = ProtocolLibrary.getProtocolManager();
		
		HN_Event.setPlugin(this);
		getServer().getPluginManager().registerEvents(new HN_Event(), this);
        
        getCommand("HoName").setExecutor(new HN_Cmd());
        getCommand("HoName").setTabCompleter(new HN_Cmd());
        
        getConfig().options().copyDefaults(true);
        saveConfig();
	}

}
