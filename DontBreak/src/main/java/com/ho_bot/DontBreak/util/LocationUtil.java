package com.ho_bot.DontBreak.util;

import java.util.Arrays;

import org.bukkit.Location;

public class LocationUtil {
	
	public static boolean isIn (Location loc1, Location loc2, Location player_loc){
		
		double[] Loc_X = {loc1.getX(), loc2.getX()};
		double[] Loc_Y = {loc1.getY(), loc2.getY()};
		double[] Loc_Z = {loc1.getZ(), loc2.getZ()};
		
		Arrays.sort(Loc_X);
		Arrays.sort(Loc_Y);
		Arrays.sort(Loc_Z);
		
		Loc_Y[1] = Loc_Y[1];
		
		double P_X = player_loc.getX();
		double P_Y = player_loc.getY();
		double P_Z = player_loc.getZ();
		
		if(!loc1.getWorld().getName().equalsIgnoreCase(player_loc.getWorld().getName())) return false;
		if((Loc_X[0] <= P_X && P_X <= Loc_X[1]) && (Loc_Y[0] <= P_Y && P_Y <= Loc_Y[1]) && (Loc_Z[0] <= P_Z && P_Z <= Loc_Z[1])) {
			return true;
		}
		return false;
	}

}
