package com.ho_bot.HB_Rune.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import com.ho_bot.HB_Rune.file.PlayerRuneFile;
import com.ho_bot.HB_Rune.inv.RuneInv;
import com.ho_bot.HB_Rune.inv.RuneSetupInv;
import com.ho_bot.HB_Rune.util.RuneUtil;

public class minecraftEvent implements Listener {
	
	private RuneUtil runeU = new RuneUtil();
	private PlayerRuneFile PRF = new PlayerRuneFile();
	private RuneInv runeI = new RuneInv();
	private RuneSetupInv runeSi = new RuneSetupInv();
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		PRF.createPlayerFile(event.getPlayer().getUniqueId());
		runeU.reloadPlayerRune(event.getPlayer());
	}
	
	@EventHandler
	public void InventoryClick(InventoryClickEvent event) {
		runeSi.EventRuneChooseClick(event);
		runeSi.EventRuneSettingClick(event);
	}
	
	@EventHandler
	public void InventoryClose(InventoryCloseEvent event) {
		runeSi.EventRuneSettingClose(event);
	}
	
	@EventHandler
	public void EntityDamageEvent(EntityDamageEvent event) {
		
	}
	
	@EventHandler
	public void EntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(!(event.getDamager() instanceof Player p)) return;
		runeU.getPlayerRune(p.getUniqueId()).EntityDamageByEntityEvent(event);
	}
	
	@EventHandler
	public void EntityDeath(EntityDeathEvent event) {
		
	}

}
