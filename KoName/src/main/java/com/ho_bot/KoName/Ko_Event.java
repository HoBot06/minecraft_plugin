package com.ho_bot.KoName;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import com.ho_bot.KoName.File.NameFile;
import com.ho_bot.KoName.Util.ArmorStandUtil;
import com.ho_bot.KoName.Util.NameUtil;

public class Ko_Event implements Listener{
	
	public static Ko_Main plugin;

	public static void setPlugin(Ko_Main MainPlugin) {
		plugin = MainPlugin;
	}
	
	public NameFile nameF = new NameFile();
	public NameUtil nameU = new NameUtil();
	public ArmorStandUtil armorstandU = new ArmorStandUtil();
	
	@EventHandler
	public void PlayerJoin(PlayerJoinEvent event) {
		nameF.createName(event.getPlayer());
		nameU.refreshNick(event.getPlayer());
	}
	
	/*@EventHandler
	public void onMove(PlayerMoveEvent event) {
		armorstandU.moveStand(event.getPlayer().getUniqueId(), event.getTo(), event.getFrom());
	}*/

}
