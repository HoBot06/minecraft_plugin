package com.ho_bot.Horavity.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class GravityUtil {
	
	public DirectionUtil directionU = new DirectionUtil();
	
	public void grab_on(Player player) {
		Entity entity = directionU.getEntity(player, VarUtil.gravity_range, VarUtil.gravity_area);
		if(entity!=null) {
			player.sendMessage("그랩");
			VarUtil.gravity_map.put(player.getUniqueId(), entity);
			return;
		}
		Block block = directionU.getBlock(player, VarUtil.gravity_range, VarUtil.gravity_not_block);
		if(block!=null) {
			BlockDisplay display = block.getWorld().spawn(block.getLocation(), BlockDisplay.class);
			display.setBlock(block.getBlockData());
			VarUtil.gravity_map.put(player.getUniqueId(), display);
			block.getWorld().getBlockAt(block.getLocation()).setType(Material.AIR);
			player.sendMessage("그랩");
			return;
		}
		player.sendMessage("그랩 안됨");
	}
	
	public void grab_off(Player player) {
		if(VarUtil.gravity_map.containsKey(player.getUniqueId())) {
			Entity entity = VarUtil.gravity_map.get(player.getUniqueId());
			if(entity instanceof BlockDisplay) {
				entity.getWorld().getBlockAt(entity.getLocation()).setBlockData(((BlockDisplay) entity).getBlock());
				entity.remove();
			}
			else {
				entity.teleport(entity.getLocation());
			}
			VarUtil.gravity_map.remove(player.getUniqueId());
			player.sendMessage("그랩 해제 됨");
		}
		else {
			player.sendMessage("그랩 한게 없음");
		}
	}
 
}
