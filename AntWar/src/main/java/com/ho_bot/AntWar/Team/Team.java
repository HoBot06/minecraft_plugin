package com.ho_bot.AntWar.Team;

import java.util.List;

import org.bukkit.entity.Player;

import com.ho_bot.AntWar.Util.ColorUtil;

public class Team {
	
	public String TeamName;
	public String TeamDisplay;
	public List<Player> TeamPlayer;
	public ColorUtil.AntColor Color;
	public long TeamResource;
	
	public Team(String TeamName, String TeamDisplay, List<Player> TeamPlayer, ColorUtil.AntColor Color, long TeamResource) {
		this.TeamName = TeamName;
		this.TeamDisplay = TeamDisplay;
		this.TeamPlayer = TeamPlayer;
		this.Color = Color;
		this.TeamResource = TeamResource;
	}

}
