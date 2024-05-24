package com.ho_bot.AntWar.Team;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import com.ho_bot.AntWar.File.TeamFile;
import com.ho_bot.AntWar.Util.ColorUtil;

public class TeamCommand {
	
	public TeamFile TeamF = new TeamFile();
	
	public void setTeam(String TeamName, String TeamDisplay, ColorUtil.AntColor Color) {
		TeamF.addTeamFile(TeamName, TeamName, null, Color, 0);
	}
	
	public Team getTeam(String TeamName) {
		for(Team team : TeamF.getTeamFile()) {
			if(team.TeamName.equalsIgnoreCase(TeamName)) {
				return team;
			}
		}
		return null;
	}
	
	public void removeTeam(String TeamName) {
		List<Team> fix_teamlist = new ArrayList<Team>();
		for(Team team : TeamF.getTeamFile()) {
			if(!team.TeamName.equalsIgnoreCase(TeamName)) {
				fix_teamlist.add(team);
			}
		}
		TeamF.setTeamFile(fix_teamlist);
	}
	
	public void setPlayerTeam(String TeamName, Player player) {
		removePlayerTeam(player);
		List<Team> fix_teamlist = new ArrayList<Team>();
		for(Team team : TeamF.getTeamFile()) {
			if(team.TeamName.equalsIgnoreCase(TeamName)) {
				team.TeamPlayer.add(player);
			}
			fix_teamlist.add(team);
		}
		TeamF.setTeamFile(fix_teamlist);
	}
	
	public String getPlayerTeam(String TeamName, Player player) {
		for(Team team : TeamF.getTeamFile()) {
			if(team.TeamName.equalsIgnoreCase(TeamName)) {
				if(team.TeamPlayer.contains(player)) {
					return team.TeamName;
				}
			}
		}
		return null;
	}
	
	public void removePlayerTeam(Player player) {
		List<Team> fix_teamlist = new ArrayList<Team>();
		for(Team team : TeamF.getTeamFile()) {
			if(team.TeamPlayer.contains(player)) {
				List<Player> plist = team.TeamPlayer;
				plist.remove(player);
				fix_teamlist.add(new Team(team.TeamName, team.TeamDisplay, plist, team.Color, team.TeamResource));
			}
			else {
				fix_teamlist.add(team);
			}
		}
		TeamF.setTeamFile(fix_teamlist);
	}

}
