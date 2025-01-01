package com.ho_bot.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.ScoreboardManager;

import com.ho_bot.dlc.VarDlc;
import com.ho_bot.util.DLCUtil;

public class DLC_Var extends JavaPlugin {
	
	public static DLC_Var inst;
	public static ScoreboardManager scoreManager;
	
	private final String key = "DLC_Var";
	
	@Override
	public void onEnable() {
		inst = this;
		scoreManager = Bukkit.getScoreboardManager();
		Bukkit.getConsoleSender().sendMessage("DLC_Var " + getDescription().getVersion() + " Online");
        
        getConfig().options().copyDefaults(true);
        saveConfig();
		
		DLCUtil.addDlc(key, new VarDlc(key));
	}

}