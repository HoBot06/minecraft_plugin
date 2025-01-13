package com.ho_bot.HB_Rune.rune;

import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.ho_bot.HB_Rune.util.VarUtil.AbilityType;

public class PassiveRune extends Rune {
	
	public PassiveRune(String id) {
		this.id = id;
	}
	
	@Override
	public boolean RuneTimer() {
		if(this.abilityType != AbilityType.Timer) return false;
		return true;
	}
	
	@Override
	public boolean EntityDamage(EntityDamageEvent event) {
		if(this.abilityType != AbilityType.takeDamage) return false;
		if(event.getEntity() instanceof Player) return true;
		return false;
	}
	
	@Override
	public boolean EntityDamageByEntity(EntityDamageByEntityEvent event) {
		if(this.abilityType != AbilityType.giveDamage) return false;
		if(event.getDamager() instanceof Player) return true;
		return false;
	}
	
	@Override
	public boolean PlayerInteract(PlayerInteractEvent event) {
		if(this.abilityType != AbilityType.RightClick && this.abilityType == AbilityType.LeftClick) return false;
		if(this.abilityType == AbilityType.LeftClick) {
			if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) return true;
		}
		if(this.abilityType == AbilityType.RightClick) {
			if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) return true;
		}
		return false;
	}
	
	@Override
	public boolean EntityDeath(EntityDeathEvent event) {
		if(this.abilityType != AbilityType.KillEntity) return false;
		if(event.getEntity().getKiller() != null) return true;
		return false;
	}
	
	@Override
	public boolean PlayerDeath(PlayerDeathEvent event) {
		if(this.abilityType != AbilityType.DeathPlayer) return false;
		return true;
	}
	
	

}
