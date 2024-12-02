package com.ho_bot.Horavity.timer;

import java.util.Map.Entry;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

import com.ho_bot.Horavity.util.DirectionUtil;
import com.ho_bot.Horavity.util.VarUtil;

public class GravityTimer extends BukkitRunnable{
	
	public DirectionUtil directionU = new DirectionUtil();

	@Override
	public void run() {
		for(Entry<UUID, Entity> entry : VarUtil.gravity_map.entrySet()) {
			VarUtil.gravity_map.get(entry.getKey()).teleport(directionU.getControl_Loc(Bukkit.getPlayer(entry.getKey()), VarUtil.gravity_range, VarUtil.gravity_not_block));
		}
	}
	
	

}
