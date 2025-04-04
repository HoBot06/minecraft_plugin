package com.ho_bot.Horavity.timer;

import org.bukkit.Location;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.ho_bot.Horavity.util.DirectionUtil;
import com.ho_bot.Horavity.util.VarUtil;

public class GravityTimer extends BukkitRunnable{
	
	public DirectionUtil directionU = new DirectionUtil();

	public Entity entity;
	public Player player;
	
	public GravityTimer(Player player, Entity entity) {
		this.player = player;
		this.entity = entity;
	}
	
	@Override
	public void run() {
		if(!VarUtil.is_Grab.getOrDefault(player.getUniqueId(), false)) {
			Location loc = entity.getLocation().getBlock().getLocation();
			if(entity instanceof BlockDisplay) {
				entity.getWorld().getBlockAt(loc).setBlockData(((BlockDisplay) entity).getBlock());
				entity.remove();
			}
			else {
				entity.teleport(loc);
			}
			cancel();
			return;
		}
		entity.teleport(directionU.getControl_Loc(player, VarUtil.gravity_range, VarUtil.gravity_not_block));
	}
	
	

}
