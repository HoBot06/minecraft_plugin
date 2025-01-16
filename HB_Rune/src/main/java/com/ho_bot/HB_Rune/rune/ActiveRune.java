package com.ho_bot.HB_Rune.rune;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.ho_bot.HB_Rune.util.VarUtil.AbilityType;

public class ActiveRune extends Rune{

	public ActiveRune(String id) {
		this.id = id;
	}
	
	@Override
	public void active(EntityDamageEvent event, int amp_val, double amp_per) {
		
	}
	
	@Override
	public void active(EntityDamageByEntityEvent event, int amp_val, double amp_per) {
		Player player = (Player) event.getDamager();
		if(this.abilityType == AbilityType.Potion) Potion(player, amp_val, amp_per);
		if(this.abilityType == AbilityType.Exp) return;
		if(this.abilityType == AbilityType.Damage) Damage(event, amp_val, amp_per);
		if(this.abilityType == AbilityType.Crit);
		if(this.abilityType == AbilityType.Heal) Heal(player, amp_val, amp_per);
	}
	
	@Override
	public void active(PlayerInteractEvent event, int amp_val, double amp_per) {
		
	}
	
	@Override
	public void active(EntityDeathEvent event, int amp_val, double amp_per) {
		Player player = event.getEntity().getKiller();
		if(this.abilityType == AbilityType.Potion) Potion(player, amp_val, amp_per);
		if(this.abilityType == AbilityType.Exp) Exp(event, amp_val, amp_val);
		if(this.abilityType == AbilityType.Damage) return;
		if(this.abilityType == AbilityType.Crit) return;
		if(this.abilityType == AbilityType.Heal) Heal(player, amp_val, amp_per);
	}
	
	@Override
	public void active(PlayerDeathEvent event, int amp_val, double amp_per) {
		
	}
	
	private void Potion(Player player, int amp_val, double amp_per) {
		PotionEffectType potion = PotionEffectType.getByName(this.abilityEffet);
		player.addPotionEffect(new PotionEffect(potion, (int) plusAmp(duration, amp_val, amp_per), power_val));
	}
	
	private void Damage(EntityDamageByEntityEvent event, int amp_val, double amp_per) {
		double damage = power_val * (1d+(power_per/100d));
		damage = plusAmp(damage, amp_val, amp_per);
		event.setDamage(event.getDamage() + damage);
	}
	
	private void Crit(EntityDamageByEntityEvent event, int amp_val, double amp_per) {
		
	}
	
	private void Exp(EntityDeathEvent event, int amp_val, double amp_per) {
		int exp = (int) plusAmp(event.getDroppedExp(), power_val, power_per);
		exp = (int) plusAmp(exp, amp_val, amp_per);
		event.setDroppedExp(exp);
	}
	
	private void Exp(BlockBreakEvent event, int amp_val, double amp_per) {
		int exp = (int) plusAmp(event.getExpToDrop(), power_val, power_per);
		exp = (int) plusAmp(exp, amp_val, amp_per);
		event.setExpToDrop(exp);
	}
	
	private void Heal(Player player, int amp_val, double amp_per) {
		double healAmo = power_val * (1d+(power_per/100d));
		healAmo = plusAmp(healAmo, amp_val, amp_per);
		if(player.getHealth() + healAmo >= player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()) {
			player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
		}
		else {
			player.setHealth(player.getHealth() + healAmo);
		}
	}
	
	private <T> double plusAmp(T t, int val, double per) {
		if(t instanceof Number n) {
			return (n.doubleValue()+val)*(1d+(per/100d));
		}
		return 0;
	}

}
