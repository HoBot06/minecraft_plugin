package com.ho_bot.Siege_Flag;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.ho_bot.Siege_Flag.Command.SF_Command;
import com.ho_bot.Siege_Flag.Command.SF_TabCompleter;
import com.ho_bot.Siege_Flag.Team.TeamEvent;

public class Siege_Flag extends JavaPlugin{

	public void onEnable()
    {
        Bukkit.getConsoleSender().sendMessage("Siege_Flag v1.0 Online");
        
        TeamEvent.setPlugin(this);
        TeamEvent teamevent = new TeamEvent();
        
        getServer().getPluginManager().registerEvents(teamevent, this);
        
        getCommand("SiegeF").setExecutor(new SF_Command());
        getCommand("SiegeF").setTabCompleter(new SF_TabCompleter());
    }
	
}
