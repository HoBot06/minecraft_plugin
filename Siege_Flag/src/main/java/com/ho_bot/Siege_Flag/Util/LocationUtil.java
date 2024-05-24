package com.ho_bot.Siege_Flag.Util;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class LocationUtil {
	
	public static boolean isInArea(Player player, Location Pos1, Location Pos2) {
		Location PlayerLoc = player.getLocation();
        if(Math.max(Pos1.getX(), Pos2.getX()) >= PlayerLoc.getX() && PlayerLoc.getX() >= Math.min(Pos1.getX(), Pos2.getX()) && 
        		Math.max(Pos1.getY(), Pos2.getY()) >= PlayerLoc.getY() && PlayerLoc.getY() >= Math.min(Pos1.getY(), Pos2.getY()) && 
        		Math.max(Pos1.getZ(), Pos2.getZ()) >= PlayerLoc.getZ() && PlayerLoc.getZ() >= Math.min(Pos1.getZ(), Pos2.getZ())) {
        	return true;
        }
        return false;
	}

}
