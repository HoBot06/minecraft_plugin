package com.ho_bot.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.ScoreboardManager;

import com.ho_bot.event.StaminaEvent;
import com.ho_bot.file.ConfigFile;
import com.ho_bot.timer.foodTimer;
import com.ho_bot.timer.staminaTimer;

public class Hotamina extends JavaPlugin{
	
	public static Hotamina inst;
	public static ScoreboardManager scoreManager;
	
	private ConfigFile configF = new ConfigFile();
	
	@Override
	public void onEnable() {
		inst = this;
		scoreManager = Bukkit.getScoreboardManager();
		
		StaminaEvent.setPlugin(this);
		getServer().getPluginManager().registerEvents(new StaminaEvent(), this);
		
		getConfig().options().copyDefaults(true);
        saveConfig();
        
        configF.reloadConfig();
		
		staminaTimer staminaT = new staminaTimer();
		staminaT.runTaskTimer(this, 0L, 2L);
		
		foodTimer foodT = new foodTimer();
		foodT.runTaskTimer(this, 0L, 20L);
	}

}
