package com.ho_bot.Siege_Flag.Area;

import org.bukkit.Location;
import org.bukkit.Material;

public class Area {
	
	public final String AreaName;
	public Material AreaBlock;
	public Location AreaLoc1;
	public Location AreaLoc2;
	
	public Area(String AreaName, Material AreaBlock, Location AreaLoc1, Location AreaLoc2) {
		this.AreaName = AreaName;
		this.AreaBlock = AreaBlock;
		this.AreaLoc1 = AreaLoc1;
		this.AreaLoc2 = AreaLoc2;
	}

}
