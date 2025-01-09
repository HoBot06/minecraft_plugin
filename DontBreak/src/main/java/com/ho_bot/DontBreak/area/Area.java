package com.ho_bot.DontBreak.area;

import org.bukkit.Location;

public class Area {
	
	public final String areaName;
	public final Location loc1;
	public final Location loc2;
	
	public Area(String areaName, Location loc1, Location loc2) {
		this.areaName = areaName;
		this.loc1 = loc1;
		this.loc2 = loc2;
	}

}
