package com.ho_bot.HB_Rune.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import com.ho_bot.HB_Rune.file.PlayerRuneFile;
import com.ho_bot.HB_Rune.main.HB_Rune;
import com.ho_bot.HB_Rune.util.RuneUtil;

public class HB_Event implements Listener {
	
	public static HB_Rune plugin;

	public static void setPlugin(HB_Rune MainPlugin)
    {
        plugin = MainPlugin;
    }
	
	private RuneUtil runeU = new RuneUtil();
	private PlayerRuneFile PRF = new PlayerRuneFile();
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		PRF.createPlayerFile(event.getPlayer().getUniqueId());
	}
	
	@EventHandler
	public void EntityDamageEvent(EntityDamageEvent event) {
		
	}
	
	@EventHandler
	public void EntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(!(event.getDamager() instanceof Player p)) return;
		runeU.getPlayerRune(p.getUniqueId()).EntityDamageByEntityEvent(event);
	}

}
