package com.ho_bot.HB_Rune.rune;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.ho_bot.HB_Rune.util.VarUtil.AbilityType;

public class ActiveRune extends Rune{

	public ActiveRune(String id) {
		this.id = id;
	}
	
	@Override
	public void active(Player player ,float amp_val, float amp_per) {
		if(this.abilityType == AbilityType.Potion) Potion(player, amp_val, amp_per);
	}
	
	private void Potion(Player player, float amp_val, float amp_per) {
		PotionEffectType potion = null;
		if(this.abilityEffet.equalsIgnoreCase("신속")) potion = PotionEffectType.SPEED;
		
		player.addPotionEffect(new PotionEffect(potion, (int) plusAmp(duration, amp_val, amp_per), power));
	}
	
	private <T> float plusAmp(T t, float amp_val, float amp_per) {
		if(t instanceof Number n) {
			return (n.floatValue()+amp_val)*(1f+(amp_per/100f));
		}
		return 0;
	}

}
