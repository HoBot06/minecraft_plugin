package com.ho_bot.timer;

import java.util.Map.Entry;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.ho_bot.util.ActionBarUtil;
import com.ho_bot.util.VarUtil;

public class staminaTimer extends BukkitRunnable{
	
	private ActionBarUtil actionU = new ActionBarUtil();

	@Override
	public void run() {
		for(Entry<UUID, Integer> entry : VarUtil.Player_Stamina.entrySet()) {
			Player player = Bukkit.getPlayer(entry.getKey());
			actionU.sendAction(player, "스테미나: " + entry.getValue());
			VarUtil.Player_Stamina.put(entry.getKey(), Math.min(100, entry.getValue()+1));
		}
		
	}

}
