package com.ho_bot.ApiGame.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.ScoreboardManager;

import com.ho_bot.ApiGame.cmd.DLC_Cmd;
import com.ho_bot.ApiGame.dlc.DLC;
import com.ho_bot.ApiGame.event.DLC_Event;
import com.ho_bot.ApiGame.event.Dia_Event;
import com.ho_bot.ApiGame.file.ConfigFile;
import com.ho_bot.ApiGame.file.DiaFile;
import com.ho_bot.ApiGame.file.RoulFile;
import com.ho_bot.ApiGame.timer.BoardTimer;
import com.ho_bot.ApiGame.util.VarUtil;
import com.ho_bot.util.DLCUtil;

public class DLC_ApiGame extends JavaPlugin {
	
	public static DLC_ApiGame inst;
	public static ScoreboardManager scoreManager;
	private final String key = "ApiGame";
	
	private ConfigFile configF = new ConfigFile();
	private DiaFile diaF = new DiaFile();
	private RoulFile roulF = new RoulFile();
	
	private BoardTimer boardT = new BoardTimer();
	
	@Override
	public void onEnable() {
		inst = this;
		scoreManager = Bukkit.getScoreboardManager();
		Bukkit.getConsoleSender().sendMessage("DLC_ApiGame " + getDescription().getVersion() + " Online");
		
        getServer().getPluginManager().registerEvents(new DLC_Event(), this);
        getServer().getPluginManager().registerEvents(new Dia_Event(), this);
        
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        
        getCommand("ApiGame").setExecutor(new DLC_Cmd());
        getCommand("ApiGame").setTabCompleter(new DLC_Cmd());
        
        DLCUtil.addDlc(key, new DLC(key));
        
        diaF.reloadDiaFile();
        roulF.reloadRoul();
        
        configF.reloadConfig();
        
        if(VarUtil.apiGameConfig.able) {
        	VarUtil.turnBoard = true;
        	boardT.runTaskTimerAsynchronously(inst, 0, VarUtil.apiGameConfig.time);
        }
	}

}
