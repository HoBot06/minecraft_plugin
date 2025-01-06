package com.ho_bot.HB_Rune.rune;

import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import com.ho_bot.HB_Rune.util.VarUtil.RuneType;

public class Rune {
	
	public String id;
	public RuneType type;
	
	public float P_potion_val = 0;
	public float P_potion_per = 1;
	
	public void active() {};
	
	public boolean EntityDamage(EntityDamageEvent event) { return false; };
	public boolean EntityDamageByEntity(EntityDamageByEntityEvent event) { return false; };
	public boolean PlayerJoin(PlayerJoinEvent event) { return false; };

}
