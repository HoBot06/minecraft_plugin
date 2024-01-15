package com.ho_bot.Siege_Flag.Team;

import org.bukkit.Material;

public class Team {
	
	public final String TeamName;
	public final String DisplayName;
	public final String TeamColor;
	public final Material TeamBlock;
	
	public Team(String TeamName, String DisplayName, String TeamColor, Material TeamBlock) {
		this.TeamName = TeamName;
		this.DisplayName = DisplayName;
		this.TeamColor = TeamColor;
		this.TeamBlock = TeamBlock;
	}

}
