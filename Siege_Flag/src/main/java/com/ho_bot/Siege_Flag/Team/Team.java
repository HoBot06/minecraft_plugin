package com.ho_bot.Siege_Flag.Team;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Team {
	
	public final String TeamName;
	public final String DisplayName;
	public final String TeamColor;
	public final Material TeamBlock;
	public List<Player> playerlist = new ArrayList<Player>();
	
	public Team(String TeamName, String DisplayName, String TeamColor, Material TeamBlock) {
		this.TeamName = TeamName;
		this.DisplayName = DisplayName;
		this.TeamColor = TeamColor;
		this.TeamBlock = TeamBlock;
	}
	
	public void addPlayer(Player player) {
		playerlist.add(player);
	}
	
	public List<Player> getPlayer() {
		return playerlist;
	}
	
	public void removePlayer(Player player) {
		playerlist.remove(player);
	}
	
	public boolean hasPlayer(Player player) {
		if(playerlist.contains(player)) {
			return true;
		}
		else {
			return false;
		}
	}

}
