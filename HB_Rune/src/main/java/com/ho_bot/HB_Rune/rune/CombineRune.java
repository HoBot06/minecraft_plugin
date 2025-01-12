package com.ho_bot.HB_Rune.rune;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.ho_bot.HB_Rune.util.VarUtil.RuneType;

public class CombineRune extends Rune{

	public List<Rune> runelist = new ArrayList<>();

	public CombineRune() {};
	
	public void addRune(Rune rune) {
		if(rune.type == RuneType.Power) {
			this.amp_per += rune.amp_per;
			this.amp_val += rune.amp_val;
		}
		else {
			runelist.add(rune);
		}
	}
	
	public void EntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		for(Rune passiveR : runelist) {
			if(passiveR.type != RuneType.Passive) continue;
			if(passiveR.EntityDamageByEntity(event)) {
				for(Rune activeR : runelist) {
					if(activeR.type != RuneType.Active) continue;
					activeR.active((Player) event.getDamager(), amp_val, amp_per);
				}
			}
		}
		return;	
	}
	
	public void EntityDamageEvent(EntityDamageEvent event) {
		for(Rune passiveR : runelist) {
			if(passiveR.type != RuneType.Passive) continue;
			if(passiveR.EntityDamage(event)) {
				for(Rune activeR : runelist) {
					if(activeR.type != RuneType.Active) continue;
					activeR.active((Player) event.getEntity(), amp_val, amp_per);
				}
			}
		}
		return;
	}
	
	public void PlayerInteractEvent(PlayerInteractEvent event) {
		for(Rune passiveR : runelist) {
			if(passiveR.type != RuneType.Passive) continue;
			if(passiveR.PlayerInteract(event)) {
				for(Rune activeR : runelist) {
					if(activeR.type != RuneType.Active) continue;
					activeR.active(event.getPlayer(), amp_val, amp_per);
				}
			}
		}
		return;	
	}
	
	public void EntityDeathEvent(EntityDeathEvent event) {
		for(Rune passiveR : runelist) {
			if(passiveR.type != RuneType.Passive) continue;
			if(passiveR.EntityDeath(event)) {
				for(Rune activeR : runelist) {
					if(activeR.type != RuneType.Active) continue;
					//activeR.active(event, amp_val, amp_per);
				}
			}
		}
		return;	
	}
}
