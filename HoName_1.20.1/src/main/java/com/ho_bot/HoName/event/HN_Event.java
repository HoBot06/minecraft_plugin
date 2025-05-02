package com.ho_bot.HoName.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.ho_bot.HoName.file.PlayerFile;
import com.ho_bot.HoName.main.HoName;
import com.ho_bot.HoName.util.NameUtil;

public class HN_Event implements Listener{
	
	public static HoName plugin;

	public static void setPlugin(HoName MainPlugin)
    {
        plugin = MainPlugin;
    }
	
	private PlayerFile playerF = new PlayerFile();
	private NameUtil nameU = new NameUtil();
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void onJoin(PlayerJoinEvent event) {
		playerF.createPlayerFile(event.getPlayer());
		nameU.reloadNick(event.getPlayer());
	}
}
