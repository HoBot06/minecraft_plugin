package com.ho_bot.timer;

import java.util.Map.Entry;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.ho_bot.util.ActionBarUtil;
import com.ho_bot.util.BoardUtil;
import com.ho_bot.util.VarUtil;

public class staminaTimer extends BukkitRunnable{
	
	//private ActionBarUtil actionU = new ActionBarUtil();
	private BoardUtil boardU = new BoardUtil();

	@Override
	public void run() {
		for(Entry<UUID, Float> entry : VarUtil.Player_Stamina.entrySet()) {
			if(Bukkit.getPlayer(entry.getKey())!=null) {
				Player player = Bukkit.getPlayer(entry.getKey());
				//actionU.sendAction(player, "피로도: " + getStamina(entry.getValue()));
				boardU.reloadScoreBoard(player, "피로도: " + getStamina(entry.getValue()));
				VarUtil.Player_Stamina.put(entry.getKey(), Math.min(VarUtil.maxStamina, entry.getValue()+VarUtil.healperStamina/10));
				setDeBuff(player, entry.getValue());
				if(VarUtil.Player_Stamina.get(player.getUniqueId())<= VarUtil.f_desStamina) {
					if(!VarUtil.Player_Foodmsg.containsKey(player.getUniqueId())) {
						VarUtil.Player_Foodmsg.put(player.getUniqueId(), true);
						player.sendMessage(VarUtil.foodmsg.replace('&', ChatColor.COLOR_CHAR));
					}
				}
				else {
					if(VarUtil.Player_Foodmsg.containsKey(player.getUniqueId())) {
						VarUtil.Player_Foodmsg.remove(player.getUniqueId());
					}
				}
			}
		}
		
	}
	
	private void setDeBuff(Player player, float stamina) {
		if(stamina <= VarUtil.s_desStamina) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 20, 0), false);
			player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20, 1), false);
			return;
		}
		else if(stamina <= VarUtil.f_desStamina) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20, 0), false);
			return;
		}
		else return;
	}
	
	private String getStamina(float stamina) {
		String return_s = "";
		float count = stamina/(VarUtil.maxStamina/10);
		int i = 0;
		for(; i < count; i++) {
			return_s += ChatColor.RED+"■";
		}
		for(; i < 10; i++) {
			return_s+= ChatColor.WHITE+"■";
		}
		return return_s;
	}

}
