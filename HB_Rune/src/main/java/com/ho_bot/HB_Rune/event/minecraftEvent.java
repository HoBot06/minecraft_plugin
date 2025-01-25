package com.ho_bot.HB_Rune.event;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

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
	public void PlayerInteract(PlayerInteractEvent event) {
		if(!runeU.hasPlayerRune(event.getPlayer().getUniqueId())) return;
		runeU.getPlayerRune(event.getPlayer().getUniqueId()).PlayerInteractEvent(event);
	}
	
	@EventHandler
	public void EntityDamageEvent(EntityDamageEvent event) {
		if(!(event.getEntity() instanceof Player p)) return;
		if(!runeU.hasPlayerRune(p.getUniqueId())) return;
		runeU.getPlayerRune(p.getUniqueId()).EntityDamageEvent(event);
	}
	
	@EventHandler
	public void EntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(!(event.getDamager() instanceof Player p)) return;
		if(!runeU.hasPlayerRune(p.getUniqueId())) return;
		runeU.getPlayerRune(p.getUniqueId()).EntityDamageByEntityEvent(event);
	}
	
	@EventHandler
	public void EntityDeathEvent(EntityDeathEvent event) {
		if(event.getEntity().getKiller() == null) return;
		if(!runeU.hasPlayerRune(event.getEntity().getKiller().getUniqueId())) return;
		runeU.getPlayerRune(event.getEntity().getKiller().getUniqueId()).EntityDeathEvent(event);
	}
	
	@EventHandler
	public void PlayerDeathEvent(PlayerDeathEvent event) {
		if(!runeU.hasPlayerRune(event.getEntity().getUniqueId())) return;
		runeU.getPlayerRune(event.getEntity().getUniqueId()).PlayerDeathEvent(event);
	}

}
