package com.ho_bot.HB_Rune.rune;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
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
	public int power;
	public int amp_val;
	public double amp_per;
	
	public void active(Player player, int amp_val, double amp_per) {};
	
	public boolean EntityDamage(EntityDamageEvent event) { return false; }
	public boolean EntityDamageByEntity(EntityDamageByEntityEvent event) { return false; }
	public boolean PlayerInteract(PlayerInteractEvent event) { return false; }
}
