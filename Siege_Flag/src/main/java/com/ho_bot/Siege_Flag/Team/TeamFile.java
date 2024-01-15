package com.ho_bot.Siege_Flag.Team;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import com.ho_bot.Siege_Flag.Siege_Flag;
import com.ho_bot.Siege_Flag.Util.ColorUtil;
import com.ho_bot.Siege_Flag.Util.YmlUtil;

public class TeamFile {
	
	public YmlUtil YU = new YmlUtil();
	public ColorUtil ColorU = new ColorUtil();
	
	public void reloadTeamFile() {
		Logger log = Bukkit.getLogger();
		File file = new File(Siege_Flag.getPlugin(Siege_Flag.class).getDataFolder( ) + File.separator + "팀//config.yml");
		if(file.listFiles()==null) {
			return;
		}
		TeamVar.Teamlist.clear();
		TeamVar.Teamlist = getTeamFile();
		log.info("[Siege_Flag] 총 " + TeamVar.Teamlist.size() + " 개의 팀 확인완료");
	}
	
	public void setTeamFile(String TeamName, String DisplayName, String TeamColor, Material TeamBlock) {
		File file = new File(Siege_Flag.getPlugin(Siege_Flag.class).getDataFolder( ) + File.separator + "팀//config.yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		ConfigurationSection sel = yml.createSection("TeamList");
		for(Team team : getTeamFile()) {
			ConfigurationSection teamsel = sel.createSection(team.TeamName);
			teamsel.set("DisplayName", team.DisplayName);
			teamsel.set("TeamColor", team.TeamColor);
			teamsel.set("TeamBlock", team.TeamBlock.toString());
		}
		Team team = new Team(TeamName, DisplayName, TeamColor, TeamBlock);
		ConfigurationSection teamsel = sel.createSection(TeamName);
		teamsel.set("DisplayName", team.DisplayName);
		teamsel.set("TeamColor", team.TeamColor);
		teamsel.set("TeamBlock", team.TeamBlock.toString());
		TeamVar.Teamlist.add(team);
		YU.SetYml(file, yml);
	}
	
	public List<Team> getTeamFile() {
		File file = new File(Siege_Flag.getPlugin(Siege_Flag.class).getDataFolder( ) + File.separator + "팀//config.yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		List<Team> m_list = new ArrayList<Team>();
		if(yml.getConfigurationSection("TeamList") != null) {
			ConfigurationSection team_list = yml.getConfigurationSection("TeamList");
			Set<String> list = team_list.getKeys(false);
			for(String team_name : list) {
				ConfigurationSection teamsel = team_list.getConfigurationSection(team_name);
				Team team = new Team(team_name, teamsel.getString("DisplayName"), teamsel.getString("TeamColor"), Material.matchMaterial(teamsel.getString("TeamBlock")));
				m_list.add(team);
			}
		}
		else {
			return null;
		}
		return m_list;
	}
	
	public Team getTeam(String TeamName) {
		List<Team> teamlist = getTeamFile();
		for(Team team : teamlist) {
			if(team.TeamName.equalsIgnoreCase(TeamName)) {
				return team;
			}
		}
		return null;
	}
	
	public boolean hasTeam(String TeamName) {
		List<Team> teamlist = getTeamFile();
		for(Team team : teamlist) {
			if(team.TeamName.equalsIgnoreCase(TeamName)) {
				return true;
			}
		}
		return false;
	}
	
	public List<String> getTeamNameList() {
		List<String> teamlist = new ArrayList<String>();
		for(Team team : getTeamFile()) {
			teamlist.add(team.TeamName);
		}
		return teamlist;
	}

}
