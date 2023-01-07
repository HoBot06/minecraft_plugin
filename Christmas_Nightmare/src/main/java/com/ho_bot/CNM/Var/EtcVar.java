package com.ho_bot.CNM.Var;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public class EtcVar {
	
	public static HashMap<UUID, Location> Pos1 = new HashMap<UUID, Location>();
	public static HashMap<UUID, Location> Pos2 = new HashMap<UUID, Location>();
	public static HashMap<UUID, Boolean> isPos1 = new HashMap<UUID, Boolean>();
	public static HashMap<UUID, Boolean> isPos2 = new HashMap<UUID, Boolean>();
	public static HashMap<String, Location[]> Capture = new HashMap<String, Location[]>();
	public static HashMap<String, ArrayList<UUID>> NowInCapture = new HashMap<String, ArrayList<UUID>>();
	public static HashMap<String, String> NowCapTeam = new HashMap<String, String>();
	public static HashMap<String, Integer> TeamPoint = new HashMap<String, Integer>();
	public static HashMap<String, BossBar> CaptureBossbar = new HashMap<String, BossBar>();
	public static final List<String> CapNameList = Arrays.asList("A", "B", "C");
	public static final int[] Armor_int = {9, 14, 18, 23, 27, 32};
	public static Boolean GameSet = false;
	
	public static void AddNowCap(String CapName, Player player) {
		ArrayList<UUID> P_List = new ArrayList<UUID>();
		if (NowInCapture.containsKey(CapName)) {
			P_List = NowInCapture.get(CapName);
			if (!P_List.contains(player.getUniqueId())) {
				P_List.add(player.getUniqueId()); 
				NowInCapture.put(CapName, P_List);
			}
		}
		else {
			if (!P_List.contains(player.getUniqueId())) {
				P_List.add(player.getUniqueId()); 
				NowInCapture.put(CapName, P_List);
			}
		} 
	}
	  
	public static void RemoveNowCap(String CapName, Player player) {
		ArrayList<UUID> P_List = new ArrayList<UUID>();
		if (NowInCapture.containsKey(CapName)) {
			P_List = NowInCapture.get(CapName);
			if (P_List.contains(player.getUniqueId())) {
				P_List.remove(player.getUniqueId());
				NowInCapture.put(CapName, P_List);
			} 
		} 
	}
}
