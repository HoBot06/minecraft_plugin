package com.ho_bot.Horavity.util;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import com.ho_bot.Horavity.main.Horavity;
import com.ho_bot.Horavity.timer.GravityTimer;

public class GravityUtil {
	
	public DirectionUtil directionU = new DirectionUtil();
	
	public void grab_on(Player player) {
		Entity entity = directionU.getEntity(player, VarUtil.gravity_range, VarUtil.gravity_area);
		if(entity!=null) {
			player.sendMessage("그랩");
			VarUtil.is_Grab.put(player.getUniqueId(), true);
			GravityTimer grabT = new GravityTimer(player, entity);
			grabT.runTaskTimer(Horavity.inst, 0L, 1L);
			return;
		}
		Block block = directionU.getBlock(player, VarUtil.gravity_range, VarUtil.gravity_not_block);
		if(block!=null) {
			BlockDisplay display = block.getWorld().spawn(block.getLocation(), BlockDisplay.class);
			display.setBlock(block.getBlockData());
			VarUtil.is_Grab.put(player.getUniqueId(), true);
			GravityTimer grabT = new GravityTimer(player, display);
			grabT.runTaskTimer(Horavity.inst, 0L, 1L);
			block.getWorld().getBlockAt(block.getLocation()).setType(Material.AIR);
			player.sendMessage("그랩");
			return;
		}
		player.sendMessage("그랩 안됨");
	}
	
	public void grab_off(Player player) {
		if(VarUtil.is_Grab.containsKey(player.getUniqueId())) {
			VarUtil.is_Grab.remove(player.getUniqueId());
			player.sendMessage("그랩 해제 됨");
		}
		else {
			player.sendMessage("그랩 한게 없음");
		}
	}
 
}
