package com.ho_bot.HB_Rune.rune;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class PassiveRune extends Rune {
	
	public PassiveRune(String id) {
		this.id = id;
	}
	
	@Override
	public boolean EntityDamage(EntityDamageEvent event) {
		if(event.getEntity() instanceof Player p) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean EntityDamageByEntity(EntityDamageByEntityEvent event) {
		if(event.getDamager() instanceof Player p) {
			return true;
		}
		return false;
	}
	
	

}
