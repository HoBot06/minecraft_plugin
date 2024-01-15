package com.ho_bot.Siege_Flag.Team;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.ho_bot.Siege_Flag.Siege_Flag;

public class TeamEvent implements Listener{
	
	public static Siege_Flag plugin;
	
	public TeamGui TeamG = new TeamGui();

    public static void setPlugin(Siege_Flag MainPlugin)
    {
        plugin = MainPlugin;
    }
    
    @EventHandler
    public void InventoryClick(InventoryClickEvent event) {
    	TeamG.EventTeamSettingListGui(event);
    	TeamG.EventTeamSettingGui(event);
    	TeamG.EventTeamColorGui(event);
    }

}
