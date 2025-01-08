package com.ho_bot.HB_Rune.rune;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;

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
	public float cooldown;
	public String cooldown_msg;
	public float duration;
	public int power;
	public float amp_val;
	public float amp_per;
	
	public void active(Player player, float amp_val, float amp_per) {};
	
	public boolean EntityDamage(EntityDamageEvent event) { return false; };
	public boolean EntityDamageByEntity(EntityDamageByEntityEvent event) { return false; };
	public boolean PlayerJoin(PlayerJoinEvent event) { return false; };

}
