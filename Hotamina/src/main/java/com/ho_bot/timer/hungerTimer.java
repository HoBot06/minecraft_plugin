package com.ho_bot.timer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.ho_bot.util.VarUtil;

public class hungerTimer extends BukkitRunnable{
	
	public int count = 0;

	@Override
	public void run() {
		if(count >= VarUtil.hungerFood) {
			for(Player p : Bukkit.getOnlinePlayers()) {
				p.setFoodLevel(Math.max(0, p.getFoodLevel()-1));
			}
			count=0;
		}
		count++;
	}

}
