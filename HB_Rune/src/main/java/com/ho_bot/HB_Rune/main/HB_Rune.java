package com.ho_bot.HB_Rune.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import com.ho_bot.HB_Rune.cmd.HB_Cmd;
import com.ho_bot.HB_Rune.event.minecraftEvent;
import com.ho_bot.HB_Rune.event.mythicEvent;
import com.ho_bot.HB_Rune.file.RuneFile;
import com.ho_bot.HB_Rune.util.LogUtil;

public class HB_Rune extends JavaPlugin {
	
	public static HB_Rune inst;
	
	private RuneFile runeF = new RuneFile();
	
	public void onEnable() {
		inst = this;
		Bukkit.getConsoleSender().sendMessage("HB_Rune "+getDescription().getVersion()+" Online");
		
        getServer().getPluginManager().registerEvents(new minecraftEvent(), this);
        
        if(Bukkit.getPluginManager().getPlugin("MythicMobs") != null) {
        	getServer().getPluginManager().registerEvents(new mythicEvent(), this);
        	LogUtil.info(ChatColor.GREEN+"미스틱몹 플러그인이 인식되었습니다");
        }
        else {
        	LogUtil.info(ChatColor.RED+"미스틱몹 플러그인이 인식되지 않았습니다");
        }
        
        getCommand("룬").setExecutor(new HB_Cmd());
        getCommand("룬").setTabCompleter(new HB_Cmd());
        
        getConfig().options().copyDefaults(true);
        saveConfig();
        
        runeF.reloadRuneFile();
	}
	
	public void onDisable() {
		
	}

}
