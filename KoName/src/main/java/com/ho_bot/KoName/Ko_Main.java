package com.ho_bot.KoName;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.ho_bot.KoName.Cmd.Ko_Cmd;
import com.ho_bot.KoName.Timer.StandTimer;
import com.ho_bot.KoName.Util.NameUtil;

public class Ko_Main extends JavaPlugin{
	
	public static Plugin BackAuth;
	
	public void onEnable()
    {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Ko_Name v1.0 Online");
        
        Ko_Event.setPlugin(this);
		
        Ko_Event ko_event = new Ko_Event();
        
        getServer().getPluginManager().registerEvents(ko_event, this);
        
        getCommand("koname").setExecutor(new Ko_Cmd());
        getCommand("칭호").setExecutor(new Ko_Cmd());
        getCommand("닉네임").setExecutor(new Ko_Cmd());
        
        /*if(isConnectPlugin("BackdoorAuth")) {
        	BackAuth = Bukkit.getPluginManager().getPlugin("BackdoorAuth");
        	Bukkit.getLogger().log(Level.INFO, "[KoName] 백도어 연동됨");
        }*/
        
        /*StandTimer standT = new StandTimer();
        standT.runTaskTimer(this, 0, 1L);*/
    }
	
	public void onDisable() {
		
	}
	
	public static boolean isConnectPlugin(String name) {
		return (Bukkit.getPluginManager().getPlugin(name) != null);
	}

}
