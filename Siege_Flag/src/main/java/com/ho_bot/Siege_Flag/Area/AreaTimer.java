package com.ho_bot.Siege_Flag.Area;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.ho_bot.Siege_Flag.Team.Team;
import com.ho_bot.Siege_Flag.Team.TeamFile;
import com.ho_bot.Siege_Flag.Util.LocationUtil;

public class AreaTimer extends BukkitRunnable{
	
	public TeamFile TeamF = new TeamFile();
	public AreaFile AreaF = new AreaFile();

	public void run() {
		for(Player p : Bukkit.getOnlinePlayers()) {
			for(Area area : AreaF.getAreaFile()) {
				if(LocationUtil.isInArea(p, area.AreaLoc1, area.AreaLoc2)) {
					AreaVar.removeinArea(p);
					AreaVar.setinArea(area, p);
				}
			}
		}
		
	}

}
