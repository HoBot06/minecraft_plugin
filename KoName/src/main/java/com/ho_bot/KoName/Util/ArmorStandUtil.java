package com.ho_bot.KoName.Util;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class ArmorStandUtil {
	
	public void setNameStand(UUID uuid, String name) {
		if(!VarUtil.player_stand.containsKey(uuid)) {
			Player player = Bukkit.getPlayer(uuid);
			ArmorStand armorStand = player.getWorld().spawn(player.getLocation(), ArmorStand.class);
			armorStand.setVisible(false);
			armorStand.setCustomNameVisible(true);
			armorStand.setCustomName(name);
			armorStand.setMarker(true);
			armorStand.setGravity(false);
			
			VarUtil.player_stand.put(uuid, armorStand);
		}
		else {
			VarUtil.player_stand.get(uuid).setCustomName(name);
		}
	}
	
	public void moveStand(UUID uuid, Location loc_end, Location loc_start) {
		if(VarUtil.player_stand.containsKey(uuid)) {
			Vector d_end = new Vector(loc_end.getX(), loc_end.getY(), loc_end.getZ());
			Vector d_start = new Vector(loc_start.getX(), loc_start.getY(), loc_start.getZ());
			VarUtil.player_stand.get(uuid).teleport(Bukkit.getPlayer(uuid).getLocation().add(d_end.subtract(d_start).multiply(2.5)).add(0, 1.8, 0));
//			Bukkit.broadcastMessage(VarUtil.player_stand.get(uuid).getLocation() + " : loc");
		}
	}
	
	public void removeStand(UUID uuid) {
		if(VarUtil.player_stand.containsKey(uuid)) {
			VarUtil.player_stand.get(uuid).remove();
			VarUtil.player_stand.remove(uuid);
		}
	}

}
