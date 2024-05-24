package com.ho_bot.Siege_Flag;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.ho_bot.Siege_Flag.Area.AreaEvent;
import com.ho_bot.Siege_Flag.Area.AreaFile;
import com.ho_bot.Siege_Flag.Command.SF_Command;
import com.ho_bot.Siege_Flag.Command.SF_TabCompleter;
import com.ho_bot.Siege_Flag.Team.TeamEvent;
import com.ho_bot.Siege_Flag.Team.TeamFile;

public class Siege_Flag extends JavaPlugin{
	
	public TeamFile TeamF = new TeamFile();
	public AreaFile AreaF = new AreaFile();

	public void onEnable()
    {
        Bukkit.getConsoleSender().sendMessage("Siege_Flag v1.1 Online");
        
        TeamEvent.setPlugin(this);
        getServer().getPluginManager().registerEvents(new TeamEvent(), this);
        AreaEvent.setPlugin(this);
        getServer().getPluginManager().registerEvents(new AreaEvent(), this);
        
        getCommand("SiegeF").setExecutor(new SF_Command());
        getCommand("SiegeF").setTabCompleter(new SF_TabCompleter());
        
        TeamF.reloadTeamFile();
        AreaF.reloadAreaFile();
    }
	
}
