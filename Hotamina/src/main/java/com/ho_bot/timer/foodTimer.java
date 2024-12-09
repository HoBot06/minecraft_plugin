package com.ho_bot.timer;

import java.util.Random;
import java.util.UUID;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.ho_bot.util.VarUtil;

public class foodTimer extends BukkitRunnable{
	
	private Random rand = new Random();

	@Override
	public void run() {
		for(Entry<UUID, Float> entry : VarUtil.Player_Stamina.entrySet()) {
			Player player = Bukkit.getPlayer(entry.getKey());
			setFood(player, entry.getValue());
		}
		
	}
	
	private void setFood(Player player, float stamina) {
		if(stamina <= VarUtil.s_desStamina) {
			int food = rand.nextInt(rand.nextInt(5));
			player.setFoodLevel(Math.max(0, player.getFoodLevel()-food));
			return;
		}
		else if(stamina <= VarUtil.f_desStamina) {
			int food = rand.nextInt(rand.nextInt(3));
			player.setFoodLevel(Math.max(0, player.getFoodLevel()-food));
			return;
		}
		else return;
	}
}
