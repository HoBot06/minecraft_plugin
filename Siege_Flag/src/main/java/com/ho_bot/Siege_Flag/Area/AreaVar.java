package com.ho_bot.Siege_Flag.Area;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class AreaVar {
	
	public static List<Area> AreaList = new ArrayList<Area>();
	public static HashMap<Area, List<Player>> inArea = new HashMap<Area, List<Player>>();
	public static HashMap<Player, Boolean> AreaPlayer = new HashMap<Player, Boolean>();
	public static HashMap<Player, Location> AreaSel_left = new HashMap<Player, Location>();
	public static HashMap<Player, Location> AreaSel_right = new HashMap<Player, Location>();
	
	public static boolean getAreaPlayer(Player player) {
		if(AreaPlayer.containsKey(player)) {
			if(AreaPlayer.get(player)) {
				return true;
			}
		}
		return false;
	}
	
	public static List<String> getAreaNameList() {
		List<String> arealist = new ArrayList<String>();
		for(Area area : AreaList) {
			arealist.add(area.AreaName);
		}
		return arealist;
	}
	
	public static void setinArea(Area area, Player player){
		removeinArea(player);
		List<Player> playerlist = new ArrayList<Player>();
		if(inArea.containsKey(area)) {
			playerlist = inArea.get(area);
		}
		playerlist.add(player);
		inArea.put(area, playerlist);
	}
	
	public static void removeinArea(Player player) {
		HashMap<Area, List<Player>> fix_inArea = new HashMap<Area, List<Player>>();
		for(Entry<Area, List<Player>> entry : inArea.entrySet()) {
			List<Player> playerlist = entry.getValue();
			if(entry.getValue().contains(player)) {
				playerlist.remove(player);
			}
			fix_inArea.put(entry.getKey(), playerlist);
		}
		inArea = fix_inArea;
	}

}
