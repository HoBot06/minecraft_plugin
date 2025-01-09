package com.ho_bot.HB_Rune.timer;

import java.util.Map.Entry;
import java.util.UUID;

import org.bukkit.scheduler.BukkitRunnable;

import com.ho_bot.HB_Rune.util.VarUtil;

public class CooldownTimer extends BukkitRunnable{

	@Override
	public void run() {
		if(VarUtil.player_cool==null) return;
		for(Entry<UUID, Integer> entry : VarUtil.player_cool.entrySet()) {
			if(entry.getValue() <= 0) continue;
			else {
				VarUtil.player_cool.put(entry.getKey(), entry.getValue()-1);
			}
		}
		
	}

}
