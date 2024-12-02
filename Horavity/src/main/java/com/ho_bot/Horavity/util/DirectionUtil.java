package com.ho_bot.Horavity.util;

import java.util.Set;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class DirectionUtil {
	
	public Entity getEntity(Player player, int range, double area) {
		Location origin = player.getEyeLocation();
		Vector direction = player.getEyeLocation().getDirection();
		for(int i = 1; i <= range; i++) {
			origin.add(direction.getX() * i, direction.getY() * i, direction.getZ() * i);
			if(origin.getBlock().getType() != Material.AIR) {
				break;
			}
			for(Entity e : player.getWorld().getNearbyEntities(origin, area, area, area)) {
				if(!e.getUniqueId().equals(player.getUniqueId())) {
					return e;
				}
			}
			origin.subtract(direction.getX() * i, direction.getY() * i, direction.getZ() * i);
		}
		return null;
	}
	
	public Block getBlock(Player player, int range, Set<Material> materials) {
		return player.getTargetBlock(materials, range);
	}
	
	public Location getLocationInFront(Player player, int distance) {
        Location playerLocation = player.getLocation();
        Vector direction = playerLocation.getDirection();
        Location targetLocation = playerLocation.add(direction.multiply(distance));

        return targetLocation;
    }
	
	public Location getControl_Loc(Player player, int range, Set<Material> materials) {
		Block block = player.getTargetBlock(materials, range);
		if(block != null) {
			Location blockloc = block.getLocation().subtract(player.getLocation().getDirection().multiply(1.5f));
			return blockloc;
		}
		else {
			return getLocationInFront(player, range);
		}
	}

}
