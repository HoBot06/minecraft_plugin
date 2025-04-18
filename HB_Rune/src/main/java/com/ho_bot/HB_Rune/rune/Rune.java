package com.ho_bot.HB_Rune.rune;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.ho_bot.HB_Rune.util.VarUtil.AbilityType;
import com.ho_bot.HB_Rune.util.VarUtil.RuneType;

public class Rune {
	
	public String id;
	public RuneType type;
	
	public String name;
	public Material material;
	public List<String> lore;
	
	public AbilityType abilityType;
	public String abilityEffet;
	public int cooldown;
	public String cooldown_msg;
	public int duration;
	public int power_val;
	public double power_per;
	public int amp_val;
	public double amp_per;
	
	public String getName() {
		return name.replace('&', ChatColor.COLOR_CHAR);
	}
	
	public List<String> getLore() {
		List<String> lore = new ArrayList<>();
		for(String s : this.lore) {
			lore.add(s.replace('&', ChatColor.COLOR_CHAR));
		}
		return lore;
	}
	
	public void active(EntityDamageEvent event, int amp_val, double amp_per) {};
	public void active(EntityDamageByEntityEvent event, int amp_val, double amp_per) {};
	public void active(PlayerInteractEvent event, int amp_val, double amp_per) {};
	public void active(EntityDeathEvent event, int amp_val, double amp_per) {};
	public void active(PlayerDeathEvent event, int amp_val, double amp_per) {};
	
	public boolean EntityDamage(EntityDamageEvent event) { return false; }
	public boolean EntityDamageByEntity(EntityDamageByEntityEvent event) { return false; }
	public boolean PlayerInteract(PlayerInteractEvent event) { return false; }
	public boolean EntityDeath(EntityDeathEvent event) { return false; }
	public boolean PlayerDeath(PlayerDeathEvent event) { return false; }
	public boolean RuneTimer() { return false; }
}
